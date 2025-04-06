package br.com.trend.application.service

import br.com.trend.application.shared.dto.jwt.JwtResponse
import br.com.trend.application.shared.dto.jwt.LoginRequest
import br.com.trend.application.shared.service.IAuthService
import br.com.trend.application.shared.service.IUserService
import br.com.trend.infrastructure.jwt.JwtTokenUtil
import br.com.trend.model.user.User
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class UserSecurityService(
    @Qualifier("userService")
    private val service: IUserService,
    private val authenticationManager: ReactiveAuthenticationManager,
    private val jwtTokenUtil: JwtTokenUtil
): IAuthService {


    override suspend fun login(request: LoginRequest): JwtResponse {
        return try {
            val authenticationToken = UsernamePasswordAuthenticationToken(
                request.login, request.password
            )

            val authentication = this.authenticationManager.authenticate(authenticationToken).awaitSingle()
            val userDetails = this.service.findByLogin(request.login).awaitSingle()
            val token = this.jwtTokenUtil.generateToken(userDetails)

            JwtResponse(token)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun register(user: User): User {
        return this.service.setEntity(user)
    }

}