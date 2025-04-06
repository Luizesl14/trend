package br.com.trend.model.user

import br.com.trend.model.customer.Customer
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field


@Document(collection = "customers")
class User(

    @Id
    val id: ObjectId = ObjectId(),

    @Indexed(unique = true, name = "login_index")
    @Field("login")
    var login: String,

    @Indexed(unique = true, name = "email_index")
    @Field("email")
    val email: String,

    @Field("password")
    val password: String,

    @DBRef
    val roles: Set<String> = emptySet(),

    @DBRef
    val customer: Customer? = null

){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
