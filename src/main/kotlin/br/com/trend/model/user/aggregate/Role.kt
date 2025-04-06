package br.com.trend.model.user.aggregate

import br.com.trend.model.user.User
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "role")
class Role(

    @Id
    val id: ObjectId = ObjectId(),

    @Field("name")
    val name: String,

    @Field("is_active")
    val isActive: Boolean = false,

    @DBRef
    val user: User? = null

){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Role

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
