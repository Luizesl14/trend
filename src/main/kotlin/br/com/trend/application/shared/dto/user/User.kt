package br.com.trend.model.user

import br.com.trend.model.customer.CustomerDTO
import org.bson.types.ObjectId


data class UserDTO(

    val id: ObjectId,
    val login: String,
    val email: String,
    val password: String,
    val roles: Set<String> = emptySet(),
    val customer: CustomerDTO? = null
)