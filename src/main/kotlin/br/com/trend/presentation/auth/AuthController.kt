package br.com.trend.presentation.auth

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.application.shared.ports.IAuthControllerPort
import br.com.trend.application.shared.ports.IRoleControllerPort
import br.com.trend.application.shared.util.optionalOf
import br.com.trend.model.user.UserDTO
import br.com.trend.presentation.api.IAuthController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authPort: IAuthControllerPort,
    private val rolePort: IRoleControllerPort
): IAuthController {

    @PostMapping("/login")
    override suspend fun login(@RequestBody request: LoginRequest): ResponseEntity<JwtResponse> {
        return try {
            ResponseEntity.ok(this.authPort.login(request))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping("/register")
    override suspend fun register(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {

        val roleOffNullable = optionalOf(userDTO.roles)
            .filter { it.isNotEmpty() }
            .orElseThrow { IllegalArgumentException("Roles cannot be null or empty")}

        val savedRoles = roleOffNullable.map { roleDTO -> this.rolePort.save(roleDTO) }
        userDTO.roles = savedRoles.toSet();

        return ResponseEntity.status(HttpStatus.CREATED).body(this.authPort.register(userDTO))
    }
}