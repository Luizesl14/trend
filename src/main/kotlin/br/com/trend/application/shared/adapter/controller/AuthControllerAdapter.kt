package br.com.trend.application.shared.adapter.controller

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.application.shared.mapper.IUserMapper
import br.com.trend.application.shared.ports.IAuthControllerPort
import br.com.trend.application.shared.service.IAuthService
import br.com.trend.model.user.User
import br.com.trend.model.user.UserDTO
import org.springframework.stereotype.Component

@Component
class AuthControllerAdapter(
    private val  service : IAuthService,
    private val map: IUserMapper
): IAuthControllerPort {

    override suspend fun login(request: LoginRequest): JwtResponse {
        return this.service.login(request)
    }

    override suspend fun register(userDTO: UserDTO): UserDTO {
        val user: User = this.service.register(this.map.toEntity(userDTO));
       return this.map.toDTO(user);
    }
}