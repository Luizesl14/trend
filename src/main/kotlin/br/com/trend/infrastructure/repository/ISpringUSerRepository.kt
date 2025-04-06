package br.com.trend.infrastructure.repository

import br.com.trend.model.user.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ISpringUSerRepository : MongoRepository<User, String> {
    fun findByLogin(login: String): User
}