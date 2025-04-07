package br.com.trend.application.shared.mapper

import br.com.trend.model.customer.aggregate.Phone
import br.com.trend.model.customer.aggregate.PhoneDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IPhoneMapper {
    fun toDTO(role: Phone): PhoneDTO
    fun toEntity(dto: PhoneDTO): Phone
}
