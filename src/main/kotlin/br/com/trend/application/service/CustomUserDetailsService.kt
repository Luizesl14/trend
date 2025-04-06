package br.com.trend.application.service

import br.com.trend.application.shared.dto.user.UserSecurity
import br.com.trend.application.shared.service.IUserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val service: IUserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = this.service.findByUsername(username)
            ?: throw UsernameNotFoundException("Usuário não encontrado: $username")

        return UserSecurity(user);
    }
}