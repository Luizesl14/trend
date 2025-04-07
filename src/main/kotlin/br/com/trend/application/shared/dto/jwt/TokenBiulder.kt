package br.com.trend.application.shared.dto.jwt

data class JwtResponse(
    val token: String,
    val exp: String
)
