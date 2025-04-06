package br.com.trend.application.service

import br.com.trend.application.shared.ports.IUserPort
import br.com.trend.application.shared.service.IUserService
import br.com.trend.model.user.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: IUserPort,
    private val passwordEncoder: PasswordEncoder
): IUserService {

    override fun findByUsername(login: String): User {
        return this.repository.findByUsername((login))
    }

    override fun get(id: String): User {
        return this.repository.findById(id);
    }

    override fun getAll(): MutableSet<User> {
        TODO("Not yet implemented")
    }

    override fun setEntity(entity: User): User {
        val encodedPassword = passwordEncoder.encode(entity.password)
        entity.login = encodedPassword;
        return repository.save(entity);
    }

    override fun update(entity: User): User {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}