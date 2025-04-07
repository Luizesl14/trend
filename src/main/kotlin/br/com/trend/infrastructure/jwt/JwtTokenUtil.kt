package br.com.trend.infrastructure.jwt

import br.com.trend.application.shared.dto.jwt.Token
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil {
    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration}")
    private var expiration: Long = 86400000 // 24 horas

    fun generateToken(userDetails: UserDetails): Token {
        val claims: Map<String, Any> = hashMapOf(
            "roles" to (userDetails.authorities.map { it.authority })
        )

        var token = Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(Keys.hmacShaKeyFor(secret.toByteArray()))
            .compact();
        return Token("Bearer", token, expiration.toString())
    }



    fun getUsernameFromToken(token: String): String {
        val claims = getAllClaimsFromToken(token)
        return claims.subject
    }

    fun getRolesFromToken(token: String): List<String> {
        val claims = getAllClaimsFromToken(token)
        return claims["roles"] as List<String>
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {
        val expiration = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    private fun getExpirationDateFromToken(token: String): Date {
        val claims = getAllClaimsFromToken(token)
        return claims.expiration
    }

    private fun getAllClaimsFromToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secret.toByteArray()))
            .build()
            .parseClaimsJws(token)
            .body
    }
}