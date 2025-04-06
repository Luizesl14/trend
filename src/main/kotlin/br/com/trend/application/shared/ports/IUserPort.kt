package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.adapter.IRepositoryPort
import br.com.trend.model.user.User

interface IUserRepositoryPort: IRepositoryPort<User> {

    fun findByUsername(login: String): User
}