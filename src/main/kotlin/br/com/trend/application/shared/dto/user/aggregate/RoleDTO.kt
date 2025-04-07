package br.com.trend.model.user.aggregate

import br.com.trend.model.user.UserDTO
import org.bson.types.ObjectId


data class RoleDTO(

    val id: ObjectId? = null,
    val name: String? = null,
    val isActive: Boolean = false,
    val user: UserDTO? = null

)