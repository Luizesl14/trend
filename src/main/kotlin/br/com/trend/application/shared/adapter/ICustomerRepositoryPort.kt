package br.com.trend.application.shared.adapter

import br.com.trend.model.customer.Customer
import br.com.trend.infrastructure.repository.IRepositoryPort

interface ICustomerRepositoryPort: IRepositoryPort<Customer, Customer> {
}