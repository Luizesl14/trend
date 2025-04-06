package br.com.trend.application.service

import br.com.trend.application.shared.adapter.ICustomerRepositoryPort
import br.com.trend.model.customer.Customer
import org.springframework.stereotype.Service


@Service
class CustomerService(
    private val repository: ICustomerRepositoryPort
): ICustomerService {

    override fun getCustomer(id: String): Customer {
        return this.repository.findById(id);
    }

    override fun getCustomers(): MutableSet<Customer> {
        return this.repository.findAll();
    }

    override fun setCustomer(customer: Customer): Customer {
        return this.repository.save(customer);
    }

    override fun updateCustomer(customer: Customer): Customer {
        return this.repository.update(customer);
    }

    override fun deleteCustomer(id: String) {
        this.repository.delete(id);
    }


}