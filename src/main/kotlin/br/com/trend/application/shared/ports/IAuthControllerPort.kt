package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.adapter.IRepositoryPort
import br.com.trend.model.customer.CustomerDTO

interface ICustomerControllerPort: IRepositoryPort<CustomerDTO> {
}