package br.com.trend.application.shared.mapper

import br.com.trend.model.customer.Customer
import br.com.trend.model.customer.CustomerDTO
import org.mapstruct.Mapper


@Mapper(componentModel = "spring",  uses =
    [IRoleMapper::class,
    IPersonaMapper::class,
    IAddressMapper::class,
    IPhoneMapper::class]
)
interface ICustomerMapper {

    fun toEntity(dto: CustomerDTO): Customer
    fun toDTO(entity: Customer): CustomerDTO
    fun toEntities(customerDTO: MutableSet<CustomerDTO>): MutableSet<Customer>
    fun toDTOs(entities: MutableSet<Customer>): MutableSet<CustomerDTO>
}