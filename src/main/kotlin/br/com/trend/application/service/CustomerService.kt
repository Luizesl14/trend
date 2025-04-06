package br.com.trend.application.service

import br.com.trend.application.shared.ports.ICustomerPort
import br.com.trend.model.customer.Customer
import br.com.trend.application.shared.service.ICustomerService
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val repository: ICustomerPort
): ICustomerService {

    override fun get(id: String): Customer {
        return this.repository.findById(id);
    }

    override fun getAll(): MutableSet<Customer> {
        return this.repository.findAll();
    }

    override fun setEntity(entity: Customer): Customer {
        return this.repository.save(entity);
    }

    override fun update(entity: Customer): Customer {
        return this.repository.update(entity);
    }

    override fun delete(id: String) {
        this.repository.delete(id);
    }


}