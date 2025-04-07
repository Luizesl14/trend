package br.com.trend.application.shared.adapter.controller

import br.com.trend.application.shared.mapper.IRoleMapper
import br.com.trend.application.shared.ports.IRoleControllerPort
import br.com.trend.application.shared.service.IRoleService
import br.com.trend.model.user.aggregate.Role
import br.com.trend.model.user.aggregate.RoleDTO
import org.springframework.stereotype.Component

@Component
class RoleControllerAdapter(
    private val  service : IRoleService,
    private val map : IRoleMapper
): IRoleControllerPort {

    override fun findById(id: String): RoleDTO {
        val role: Role = this.service.get(id)
        return this.map.toDTO(role)
    }

    override fun findAll(): MutableSet<RoleDTO> {
        val roles: MutableSet<Role> = this.service.getAll();
        return this.map.toDTOs(roles)
    }

    override fun save(entity: RoleDTO): RoleDTO {
        val role: Role = this.map.toEntity(entity)
        var roleDTO = this.map.toDTO(this.service.setEntity(role));
        return roleDTO;
    }

    override fun update(entity: RoleDTO): RoleDTO {
        val role: Role = this.map.toEntity(entity)
        return this.map.toDTO(this.service.update(role))
    }

    override fun delete(id: String) {
        this.service.delete(id)
    }

}