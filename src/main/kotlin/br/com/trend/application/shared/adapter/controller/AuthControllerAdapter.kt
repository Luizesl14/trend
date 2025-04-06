package br.com.trend.application.shared.adapter.controller

import br.com.trend.application.shared.service.ICustomerService
import br.com.trend.application.shared.mapper.ICustomerMapper
import br.com.trend.application.shared.ports.ICustomerControllerPort
import br.com.trend.model.customer.Customer
import br.com.trend.model.customer.CustomerDTO
import org.springframework.stereotype.Component

@Component
class CustomControllerAdapter(
    private val  service : ICustomerService,
    private val mapper: ICustomerMapper
): ICustomerControllerPort {

    override fun findById(id: String): CustomerDTO {
        val customer: Customer = this.service.get(id)
        return mapper.toDTO(customer)
    }

    override fun findAll(): MutableSet<CustomerDTO> {
        val customers: MutableSet<Customer> = this.service.getAll();
        return this.mapper.toDTOs(customers)
    }

    override fun save(customerDTO: CustomerDTO): CustomerDTO {
        val customer: Customer = this.mapper.toEntity(customerDTO)
        return this.mapper.toDTO(this.service.setEntity(customer))
    }

    override fun update(customerDTO: CustomerDTO): CustomerDTO {
        val customer: Customer = this.mapper.toEntity(customerDTO)
        return this.mapper.toDTO(this.service.update(customer))
    }

    override fun delete(id: String) {
        this.service.delete(id)
    }

}