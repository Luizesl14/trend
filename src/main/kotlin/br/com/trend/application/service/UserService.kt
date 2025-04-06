package br.com.trend.application.service

import br.com.trend.infrastructure.repository.ISpringUSerRepository
import br.com.trend.model.user.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: ISpringUSerRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun findByUsername(login: String): User? {
        return repository.findByLogin((login))
    }

    fun createUser(user: User): User {
        val encodedPassword = passwordEncoder.encode(user.password)
        user.login = encodedPassword;
        return repository.save(user);
    }
}