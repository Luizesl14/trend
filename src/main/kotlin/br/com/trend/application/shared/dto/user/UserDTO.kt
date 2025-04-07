package br.com.trend.model.user

import br.com.trend.model.user.aggregate.RoleDTO
import org.bson.types.ObjectId


data class UserDTO (

    var id: ObjectId? = null,
    var login: String? = null,
    var email: String? = null,
    var pass: String? = null,
    var roles: Set<RoleDTO> = emptySet(),
    val isActive: Boolean = true
)