package br.com.trend.presentation.auth

import br.com.trend.infrastructure.jwt.JwtTokenUtil
import br.com.trend.application.service.UserService
import br.com.trend.model.user.User
import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: ReactiveAuthenticationManager,
    private val userDetailsService: ReactiveUserDetailsService,
    private val jwtTokenUtil: JwtTokenUtil,
    private val userService: UserService
) {

    @PostMapping("/login")
    suspend fun login(@RequestBody request: LoginRequest): ResponseEntity<JwtResponse> {
        return try {
            val authenticationToken = UsernamePasswordAuthenticationToken(
                request.login, request.password
            )

            val authentication = authenticationManager.authenticate(authenticationToken).awaitSingle()
            val userDetails = userDetailsService.findByUsername(request.login).awaitSingle()
            val token = jwtTokenUtil.generateToken(userDetails)

            ResponseEntity.ok(JwtResponse(token))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping("/register")
    suspend fun register(@RequestBody user: User): ResponseEntity<User> {
        val existingUser = userService.findByUsername(user.login)
        if (existingUser != null) {
            return ResponseEntity.badRequest().build()
        }
        val savedUser = userService.createUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
    }
}