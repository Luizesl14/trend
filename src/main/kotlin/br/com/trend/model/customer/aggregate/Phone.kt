package br.com.trend.model.customer.aggregate

import br.com.trend.model.customer.Customer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "addresses")
class Phone(

    @Id
    val id: ObjectId = ObjectId(),

    @Field("street")
    val ddd: String,

    @Field("prefix")
    val prefix: String,

    @Field("state")
    val first: String,

    @Field("last")
    val last: String,

    @Field("is_primary")
    val isPrimary: Boolean = false,

    @Field("is_whatsapp")
    val isWhatsapp: Boolean = false,

    @DBRef
    val customer: Customer? = null

){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Phone
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
