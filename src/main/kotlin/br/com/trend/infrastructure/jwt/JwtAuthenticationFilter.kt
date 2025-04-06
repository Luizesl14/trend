package br.com.trend.infrastructure.jwt

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class JwtAuthenticationFilter(
    private val userDetailsService: ReactiveUserDetailsService,
    private val jwtTokenUtil: JwtTokenUtil
) : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val request = exchange.request
        val authHeader = request.headers.getFirst("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val token = authHeader.substring(7)
            try {
                val username = jwtTokenUtil.getUsernameFromToken(token)

                return userDetailsService.findByUsername(username)
                    .filter { userDetails -> jwtTokenUtil.validateToken(token, userDetails) }
                    .map { userDetails ->
                        UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.authorities
                        )
                    }
                    .flatMap { auth ->
                        chain.filter(exchange)
                            .contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth))
                    }
                    .switchIfEmpty(chain.filter(exchange))
            } catch (e: Exception) {
                // Token inválido
            }
        }

        return chain.filter(exchange)
    }
}