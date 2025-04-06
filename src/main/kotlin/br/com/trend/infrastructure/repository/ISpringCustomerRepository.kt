package br.com.trend.infrastructure.repository

import br.com.trend.model.customer.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ISpringCustomerRepository : MongoRepository<Customer, String> {
}