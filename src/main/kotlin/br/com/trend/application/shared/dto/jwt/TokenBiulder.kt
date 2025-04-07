package br.com.trend.application.shared.dto.jwt

data class Token(
    val type: String,
    val token: String,
    val exp: String
)
