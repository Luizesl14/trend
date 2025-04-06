package br.com.trend.application.shared.ports

import br.com.trend.model.customer.Customer
import br.com.trend.infrastructure.adapter.IPort

interface ICustomerPort: IPort<Customer> {
}