package io.github.wesleyosantos91.exception.interceptor

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = [ObjectNotFoundException::class, ExceptionHandler::class])
class ObjectNotFoundExceptionMapper(private val errorResponseProcessor: ErrorResponseProcessor<Any>) : ExceptionHandler<ObjectNotFoundException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: ObjectNotFoundException?): HttpResponse<*> {
        return errorResponseProcessor.processResponse(
            ErrorContext.builder(request)
                .cause(exception)
                .errorMessage("No stock available")
                .build(), HttpResponse.badRequest<Any>())
    }
}