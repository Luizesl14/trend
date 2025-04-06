package br.com.trend.application.shared.mapper

import br.com.trend.model.user.User
import br.com.trend.model.user.UserDTO
import org.mapstruct.Mapper


@Mapper(componentModel = "spring")
interface IUserMapper {

    fun toEntity(dto: UserDTO): User
    fun toDTO(entity: User): UserDTO
    fun toEntities(customerDTO: MutableSet<UserDTO>): MutableSet<User>
    fun toDTOs(entities: MutableSet<User>): MutableSet<UserDTO>
}