package br.com.trend.application.service

import br.com.trend.application.shared.service.IUserService
import br.com.trend.model.user.User
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomReactiveUserDetailsService(
    private val service: IUserService,
) : ReactiveUserDetailsService {

    override fun findByUsername(username: String): Mono<UserDetails> {
        return try {
            val userMono: Mono<User> = this.service.findByLogin(username)
            userMono.map { user -> user as UserDetails }
        } catch (e: Exception) {
            Mono.error(UsernameNotFoundException("Usuário não encontrado: $username", e))
        }
    }

}