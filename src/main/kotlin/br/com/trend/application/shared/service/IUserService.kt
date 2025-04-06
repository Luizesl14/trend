package br.com.trend.application.shared.service

import br.com.trend.model.user.User
import reactor.core.publisher.Mono

interface IUserService: ICrudService<User> {

    fun findByLogin(login: String): Mono<User>

}