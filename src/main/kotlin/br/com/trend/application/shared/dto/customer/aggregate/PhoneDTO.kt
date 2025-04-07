package br.com.trend.model.customer.aggregate

import br.com.trend.model.customer.CustomerDTO
import org.bson.types.ObjectId

data class PhoneDTO(

    val id: ObjectId,
    val ddd: String,
    val prefix: String,
    val first: String,
    val last: String,
    val isPrimary: Boolean = false,
    val isWhatsapp: Boolean = false

)