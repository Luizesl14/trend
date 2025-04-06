package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.adapter.IPort
import br.com.trend.model.customer.CustomerDTO

interface ICustomerControllerPort: IPort<CustomerDTO> {
}