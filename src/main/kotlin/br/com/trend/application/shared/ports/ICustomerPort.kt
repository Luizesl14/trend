package br.com.trend.application.shared.ports

import br.com.trend.model.customer.Customer
import br.com.trend.infrastructure.port.IPort

interface ICustomerPort: IPort<Customer> {
}