package br.com.trend.presentation.api

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.model.user.User
import org.springframework.http.ResponseEntity

interface IAuthController {

    suspend fun login(request: LoginRequest): ResponseEntity<JwtResponse>
    suspend fun register(user: User): ResponseEntity<User>
}