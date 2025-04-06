package br.com.trend.application.shared.dto.user

import br.com.trend.model.user.User
import br.com.trend.application.shared.service.IUserDetail
import org.bson.types.ObjectId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

class UserSecurity(

    private val user: User

): IUserDetail {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return user.roles.map { SimpleGrantedAuthority(it) }
    }

    override fun getPassword(): String = user.password
    override fun getUsername(): String = user.login
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true

    fun getId(): ObjectId = user.id
}