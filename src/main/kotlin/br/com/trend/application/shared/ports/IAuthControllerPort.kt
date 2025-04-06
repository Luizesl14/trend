package br.com.trend.application.shared.ports

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.model.user.UserDTO

interface IAuthControllerPort {

    suspend fun login(request: LoginRequest): JwtResponse
    suspend fun register(userDTO: UserDTO): UserDTO

}