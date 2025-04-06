package br.com.trend.model.user

import br.com.trend.model.customer.CustomerDTO
import br.com.trend.model.user.aggregate.Role
import org.bson.types.ObjectId


data class UserDTO(

    val id: ObjectId,
    val login: String,
    val email: String,
    val password: String,
    val roles: Set<Role> = emptySet(),
    val customer: CustomerDTO? = null
)