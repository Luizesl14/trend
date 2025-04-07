package br.com.trend.application.shared.adapter.repository.user

import br.com.trend.application.shared.ports.IRolePort
import br.com.trend.application.shared.ports.IUserPort
import br.com.trend.infrastructure.repository.ISpringRoleRepository
import br.com.trend.infrastructure.repository.ISpringUserRepository
import br.com.trend.model.user.User
import br.com.trend.model.user.aggregate.Role
import org.springframework.stereotype.Component

@Component
class RoleAdapter(
    private val  repo : ISpringRoleRepository
): IRolePort {

    override fun findByLogin(login: String): Role {
        return this.repo.findByName((login))
    }

    override fun findById(id: String): Role {
        return this.repo.findById(id)
            .orElseThrow { NoSuchElementException("Entidade não encontrada com id: $id") }
    }

    override fun findAll(): MutableSet<Role> {
       return this.repo.findAll().toMutableSet();
    }

    override fun save(entity: Role): Role {
        return this.repo.save(entity);
    }

    override fun update(entity: Role): Role {
       return this.repo.save(entity);
    }

    override fun delete(id: String) {
        this.repo.deleteById(id)
    }

}