package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.port.IPort
import br.com.trend.model.user.User

interface IUserPort: IPort<User> {

    fun findByLogin(login: String): User
}