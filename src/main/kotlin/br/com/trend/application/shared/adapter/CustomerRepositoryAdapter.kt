package br.com.trend.application.shared.adapter

import br.com.trend.model.customer.Customer
import br.com.trend.infrastructure.repository.ISpringCustomerRepository
import org.springframework.stereotype.Component

@Component
class CustomerRepositoryAdapter(
    private val  repo : ISpringCustomerRepository
): ICustomerRepositoryPort {

    override fun findById(id: String): Customer {
        return this.repo.findById(id)
            .orElseThrow { NoSuchElementException("Entidade não encontrada com id: $id") }
    }

    override fun findAll(): MutableSet<Customer> {
       return this.repo.findAll().toMutableSet();
    }

    override fun save(customer: Customer): Customer {
        return this.repo.save(customer);
    }

    override fun update(customer: Customer): Customer {
       return this.repo.save(customer);
    }

    override fun delete(id: String) {
        this.repo.deleteById(id)
    }

}