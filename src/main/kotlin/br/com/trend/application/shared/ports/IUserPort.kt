package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.adapter.IPort
import br.com.trend.model.user.User

interface IUserPort: IPort<User> {

    fun findByUsername(login: String): User
}