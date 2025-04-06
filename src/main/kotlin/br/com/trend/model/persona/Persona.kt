package br.com.trend.model.persona

import br.com.trend.model.customer.Customer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document(collection = "persona")
class Persona(

    @Id
    val id: ObjectId = ObjectId(),

    @Field("first_name")
    val firstName: String,

    @Field("last_name")
    val lastName: String,

    @Field("full_name")
    val fullName: String,

    @Field("state")
    val state: String,

    @Field("zipCode")
    val zipCode: String,

    @DBRef
    val customer: Customer? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Persona
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
