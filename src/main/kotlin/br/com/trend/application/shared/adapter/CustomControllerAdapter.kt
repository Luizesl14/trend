package br.com.trend.application.shared.adapter

import br.com.trend.application.service.ICustomerService
import br.com.trend.application.shared.mapper.ICustomerMapper
import br.com.trend.model.customer.Customer
import br.com.trend.model.customer.CustomerDTO
import org.springframework.stereotype.Component

@Component
class CustomControllerAdapter(
    private val  service : ICustomerService,
    private val mapper: ICustomerMapper
): ICustomerControllerPort {

    override fun findById(id: String): CustomerDTO {
        val customer: Customer = this.service.getCustomer(id)
        return mapper.toDTO(customer)
    }

    override fun findAll(): MutableSet<CustomerDTO> {
        val customers: MutableSet<Customer> = this.service.getCustomers();
        return this.mapper.toDTOs(customers)
    }

    override fun save(customerDTO: CustomerDTO): CustomerDTO {
        val customer: Customer = this.mapper.toEntity(customerDTO)
        return this.mapper.toDTO(this.service.setCustomer(customer))
    }

    override fun update(customerDTO: CustomerDTO): CustomerDTO {
        val customer: Customer = this.mapper.toEntity(customerDTO)
        return this.mapper.toDTO(this.service.updateCustomer(customer))
    }

    override fun delete(id: String) {
        this.service.deleteCustomer(id)
    }

}