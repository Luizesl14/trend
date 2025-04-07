package br.com.trend.application.service

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.application.shared.service.IAuthService
import br.com.trend.application.shared.service.IUserService
import br.com.trend.infrastructure.jwt.JwtTokenUtil
import br.com.trend.model.user.User
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserSecurityService(
    @Qualifier("userService")
    private val service: IUserService,
    private val authenticationManager: ReactiveAuthenticationManager,
    private val jwtTokenUtil: JwtTokenUtil
): IAuthService {


    override suspend fun login(request: LoginRequest): JwtResponse {
        return try {
            val userDetails = this.service.findByLogin(request.login).awaitSingle()
            val authenticationToken = UsernamePasswordAuthenticationToken(
                request.login, request.password
            )
            val authentication = this.authenticationManager
                .authenticate(authenticationToken)
                .switchIfEmpty(Mono.error(IllegalArgumentException("Usuário ou senha inválidos")))
                .awaitSingle()

            val token = this.jwtTokenUtil.generateToken(userDetails)
            JwtResponse(token.type, token.token, token.exp)
        } catch (e: Exception) {
            when (e) {
                is org.springframework.security.core.userdetails.UsernameNotFoundException ->
                    throw IllegalArgumentException("Usuário não encontrado.")
                is org.springframework.security.authentication.BadCredentialsException ->
                    throw IllegalArgumentException("Senha incorreta.")
                is org.springframework.security.authentication.DisabledException ->
                    throw IllegalArgumentException("Usuário desativado.")
                is org.springframework.security.authentication.LockedException ->
                    throw IllegalArgumentException("Usuário bloqueado.")
                is org.springframework.security.authentication.CredentialsExpiredException ->
                    throw IllegalArgumentException("Credenciais expiradas.")
                is org.springframework.security.authentication.AccountExpiredException ->
                    throw IllegalArgumentException("Conta expirada.")
                else -> throw e
            }
        }
    }

    override suspend fun register(user: User): User {
        return this.service.setEntity(user)
    }

}