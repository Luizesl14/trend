package br.com.trend.model.customer.aggregate

import org.bson.types.ObjectId


data class AddressDTO (

    val id: ObjectId,
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val isPrimary: Boolean = false,
)








