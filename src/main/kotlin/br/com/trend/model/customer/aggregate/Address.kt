package br.com.trend.model.customer.aggregate

import br.com.trend.model.customer.Customer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "addresses")
class Address (

        @Id
        val id: ObjectId? = ObjectId(),

        @Field("street")
        val street: String,

        @Field("city")
        val city: String,

        @Field("state")
        val state: String,

        @Field("zip_code")
        val zipCode: String,

        @Field("is_primary")
        val isPrimary: Boolean = false,

        @DBRef
        val customer: Customer? = null
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}








