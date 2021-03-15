package io.github.wesleyosantos91.config.security

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException
import io.github.wesleyosantos91.repository.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword(private val userRepository: UserRepository) : AuthenticationProvider {

    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {

        var user =  userRepository.findById(authenticationRequest?.identity as String).orElseThrow {
            throw ObjectNotFoundException("Pessoa não encontrada com código: ${authenticationRequest.identity} informado.")
        }

        if (user.password == authenticationRequest.secret) {
            return Flowable.just(UserDetails(user.cpf, listOf()))
        }

        return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))

    }
}