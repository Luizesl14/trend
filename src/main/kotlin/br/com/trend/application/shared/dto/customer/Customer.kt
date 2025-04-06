package br.com.trend.model.customer

import br.com.trend.model.customer.aggregate.AddressDTO
import br.com.trend.model.customer.aggregate.PhoneDTO
import br.com.trend.model.persona.PersonaDTO
import br.com.trend.model.user.UserDTO
import org.bson.types.ObjectId


data class CustomerDTO(

    val id: ObjectId,
    val persona: Set<PersonaDTO> = emptySet(),
    val users: Set<UserDTO> = emptySet(),
    val phone: Set<PhoneDTO> = emptySet(),
    val addresses: Set<AddressDTO> = emptySet()

)
