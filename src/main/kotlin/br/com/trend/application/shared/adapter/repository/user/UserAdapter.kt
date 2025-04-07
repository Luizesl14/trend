package br.com.trend.application.shared.adapter.repository.user

import br.com.trend.application.shared.ports.IUserPort
import br.com.trend.infrastructure.repository.ISpringUserRepository
import br.com.trend.model.user.User
import org.springframework.stereotype.Component

@Component
class UserAdapter(
    private val  repo : ISpringUserRepository,
): IUserPort {

    override fun findByLogin(login: String): User {
        return this.repo.findByLogin(login)
    }

    override fun findById(id: String): User {
        return this.repo.findById(id)
            .orElseThrow { NoSuchElementException("Entidade não encontrada com id: $id") }
    }

    override fun findAll(): MutableSet<User> {
       return this.repo.findAll().toMutableSet();
    }

    override fun save(entity: User): User {
        return repo.save(entity)

    }

    override fun update(entity: User): User {
       return this.repo.save(entity);
    }

    override fun delete(id: String) {
        this.repo.deleteById(id)
    }

}