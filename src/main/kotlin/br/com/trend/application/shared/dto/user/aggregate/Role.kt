package br.com.trend.model.user.aggregate

import br.com.trend.model.user.UserDTO
import org.bson.types.ObjectId


data class RoleDTO(

    val id: ObjectId,
    val name: String,
    val isActive: Boolean = false,
    val user: UserDTO? = null

)