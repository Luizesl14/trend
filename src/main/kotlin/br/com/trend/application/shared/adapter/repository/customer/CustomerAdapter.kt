package br.com.trend.application.shared.adapter.repository.customer

import br.com.trend.application.shared.ports.ICustomerPort
import br.com.trend.infrastructure.repository.ISpringCustomerRepository
import br.com.trend.model.customer.Customer
import org.springframework.stereotype.Component

@Component
class CustomerAdapter(
    private val  repo : ISpringCustomerRepository
): ICustomerPort {

    override fun findById(id: String): Customer {
        return this.repo.findById(id)
            .orElseThrow { NoSuchElementException("Entidade não encontrada com id: $id") }
    }

    override fun findAll(): MutableSet<Customer> {
       return this.repo.findAll().toMutableSet();
    }

    override fun save(entity: Customer): Customer {
        return this.repo.save(entity);
    }

    override fun update(entity: Customer): Customer {
       return this.repo.save(entity);
    }

    override fun delete(id: String) {
        this.repo.deleteById(id)
    }

}