package br.com.trend.application.service

import br.com.trend.application.shared.ports.IRolePort
import br.com.trend.application.shared.service.IRoleService
import br.com.trend.model.user.aggregate.Role
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val repository: IRolePort
): IRoleService {

    override fun get(id: String): Role {
        return this.repository.findById(id);
    }

    override fun getAll(): MutableSet<Role> {
        TODO("Not yet implemented")
    }

    override fun setEntity(entity: Role): Role {
        return repository.save(entity);
    }

    override fun update(entity: Role): Role {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}