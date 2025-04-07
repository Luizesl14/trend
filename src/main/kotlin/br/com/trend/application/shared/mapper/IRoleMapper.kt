package br.com.trend.application.shared.mapper

import br.com.trend.model.user.aggregate.Role
import br.com.trend.model.user.aggregate.RoleDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IRoleMapper {
    fun toDTO(role: Role): RoleDTO
    fun toEntity(dto: RoleDTO): Role

    fun toEntities(customerDTO: MutableSet<RoleDTO>): MutableSet<Role>
    fun toDTOs(entities: MutableSet<Role>): MutableSet<RoleDTO>
}
