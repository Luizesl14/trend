package br.com.trend.application.shared.mapper

import br.com.trend.model.customer.aggregate.Address
import br.com.trend.model.customer.aggregate.AddressDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IAddressMapper {
    fun toDTO(role: Address): AddressDTO
    fun toEntity(dto: AddressDTO): Address
}
