package io.github.wesleyosantos91.config.security

import io.github.wesleyosantos91.repository.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) : AuthenticationProvider {

    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {

        var user =  userRepository.findByEmail(authenticationRequest?.identity as String).orElseThrow {
            throw AuthenticationException(AuthenticationFailed("Pessoa não encontrada com e-mail: ${authenticationRequest.identity} informado."))
        }

        if (passwordEncoder.matches(authenticationRequest.secret as String, user.password)) {
            return Flowable.just(UserDetails(user.email, user.roles.map { role -> role.description }))
        }

        return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))

    }
}