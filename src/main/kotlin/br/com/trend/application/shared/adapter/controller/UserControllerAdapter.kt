package br.com.trend.application.shared.adapter.controller

import br.com.trend.application.shared.mapper.IUserMapper
import br.com.trend.application.shared.ports.IUserControllerPort
import br.com.trend.application.shared.service.IUserService
import br.com.trend.model.user.User
import br.com.trend.model.user.UserDTO
import br.com.trend.model.user.aggregate.Role
import org.springframework.stereotype.Component

@Component
class UserControllerAdapter(
    private val  service : IUserService,
    private val map : IUserMapper
): IUserControllerPort {

    override fun findById(id: String): UserDTO {
        val user: User = this.service.get(id)
        return this.map.toDTO(user)
    }

    override fun findAll(): MutableSet<UserDTO> {
        val users: MutableSet<User> = this.service.getAll();
        return this.map.toDTOs(users)
    }

    override fun save(entity: UserDTO): UserDTO {
        val users: User = this.map.toEntity(entity)
        var roleDTO = this.map.toDTO(this.service.setEntity(users));
        return roleDTO;
    }

    override fun update(entity: UserDTO): UserDTO {
        val users: User = this.map.toEntity(entity)
        return this.map.toDTO(this.service.update(users))
    }

    override fun delete(id: String) {
        this.service.delete(id)
    }

}