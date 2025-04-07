package br.com.trend.infrastructure.repository

import br.com.trend.model.user.aggregate.Role
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ISpringRoleRepository : MongoRepository<Role, String> {
    fun findByName(name: String): Role

}