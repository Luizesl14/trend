package br.com.trend.model.user

import br.com.trend.model.customer.Customer
import br.com.trend.model.user.aggregate.Role
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Document(collection = "user")
class User(

    @Id
    val id: ObjectId?= ObjectId(),

    @Indexed(unique = true, name = "login_index")
    @Field("login")
    var login: String,

    @Indexed(unique = true, name = "email_index")
    @Field("email")
    val email: String,

    @Field("password")
    var pass: String,

    @DBRef
    var roles: Set<Role> = setOf(),

    @Field("is_active")
    var isActive: Boolean,

    @DBRef
    val customer: Customer? = null

): UserDetails {


    override fun getAuthorities(): Collection<GrantedAuthority> {
        return roles.map { SimpleGrantedAuthority(it.name) }
    }

    override fun getPassword(): String = pass
    override fun getUsername(): String = login

    override fun isAccountNonExpired(): Boolean = isActive
    override fun isAccountNonLocked(): Boolean = isActive
    override fun isCredentialsNonExpired(): Boolean = isActive
    override fun isEnabled(): Boolean = isActive

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
