package br.com.trend.application.shared.service

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.model.user.User

interface IAuthService {
    suspend fun login(request: LoginRequest): JwtResponse
    suspend fun register(user: User): User
}