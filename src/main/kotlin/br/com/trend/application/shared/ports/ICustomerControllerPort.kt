package br.com.trend.application.shared.adapter.controller

import br.com.trend.infrastructure.repository.IRepositoryPort
import br.com.trend.model.customer.CustomerDTO

interface ICustomerControllerPort: IRepositoryPort<CustomerDTO> {
}