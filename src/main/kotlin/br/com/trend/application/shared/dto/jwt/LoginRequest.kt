package br.com.trend.application.shared.dto.jwt

data class LoginRequest(
    val login: String,
    val password: String
)