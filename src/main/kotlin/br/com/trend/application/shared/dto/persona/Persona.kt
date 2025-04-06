package br.com.trend.model.persona

import br.com.trend.model.customer.CustomerDTO
import org.bson.types.ObjectId


data class PersonaDTO(

    val id: ObjectId,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val state: String,
    val zipCode: String,
    val customer: CustomerDTO? = null
)
