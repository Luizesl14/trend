package br.com.trend.application.service

import br.com.trend.application.shared.ports.IUserRepositoryPort
import br.com.trend.model.user.User
import br.com.trend.application.shared.service.IUserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: IUserRepositoryPort,
    private val passwordEncoder: PasswordEncoder
): IUserService {

    override fun findByUsername(login: String): User {
        return this.repository.findByUsername((login))
    }

    override fun getCustomer(id: String): User {
        return this.repository.findById(id);
    }

    override fun getCustomers(): MutableSet<User> {
        TODO("Not yet implemented")
    }

    override fun setCustomer(entity: User): User {
        val encodedPassword = passwordEncoder.encode(entity.password)
        entity.login = encodedPassword;
        return repository.save(entity);
    }

    override fun updateCustomer(entity: User): User {
        TODO("Not yet implemented")
    }

    override fun deleteCustomer(id: String) {
        TODO("Not yet implemented")
    }
}