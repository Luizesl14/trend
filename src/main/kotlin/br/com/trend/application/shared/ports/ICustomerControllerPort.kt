package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.port.IPort
import br.com.trend.model.customer.CustomerDTO

interface ICustomerControllerPort: IPort<CustomerDTO> {
}