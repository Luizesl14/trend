package br.com.trend.application.shared.dto.jwt

data class JwtResponse(
    val type: String,
    val token: String,
    val exp: String
)
