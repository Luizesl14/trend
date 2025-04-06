package br.com.trend.application.shared.adapter.service

import br.com.trend.model.user.User

interface IUserService: ICrudService<User> {

    fun findByUsername(login: String): User

}