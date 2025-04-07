package br.com.trend.application.shared.mapper

import br.com.trend.model.persona.Persona
import br.com.trend.model.persona.PersonaDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface IPersonaMapper {
    fun toDTO(role: Persona): PersonaDTO
    fun toEntity(dto: PersonaDTO): Persona
}
