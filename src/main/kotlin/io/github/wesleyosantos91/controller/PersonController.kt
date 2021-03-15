package io.github.wesleyosantos91.controller

import io.github.wesleyosantos91.model.request.CreatePersonRequest
import io.github.wesleyosantos91.model.request.UpdatePersonRequest
import io.github.wesleyosantos91.model.response.PersonResponse
import io.github.wesleyosantos91.service.PersonService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.net.URI
import javax.annotation.security.RolesAllowed

@Controller("/api/persons")
@Secured(SecurityRule.IS_AUTHENTICATED)
class PersonController(private val personService: PersonService) {

    @Produces(MediaType.APPLICATION_JSON)
    @Get
    @RolesAllowed("ROLE_READ_PERSON")
    fun findByAll(): HttpResponse<List<PersonResponse>> {
        return HttpResponse.ok(personService.findByAll())
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{code}")
    @RolesAllowed("ROLE_READ_PERSON")
    fun findByCode(@PathVariable code: Long): HttpResponse<PersonResponse> {
        return HttpResponse.ok(personService.findByCode(code))
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post
    @RolesAllowed("ROLE_CREATE_PERSON")
    fun save(@Body createPersonRequest: CreatePersonRequest): HttpResponse<PersonResponse>  {
        val response = personService.save(createPersonRequest)
        return HttpResponse
            .created(response)
            .headers { headers -> headers.location(toUri(response.code)) }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{code}")
    @RolesAllowed("ROLE_UPDADE_PERSON")
    fun update(@PathVariable code: Long, @Body updatePersonRequest: UpdatePersonRequest): HttpResponse<PersonResponse> {

        val response = personService.update(code, updatePersonRequest)
        return HttpResponse.ok(response)
            .headers { headers -> headers.location(toUri(response.code)) }
    }

    @Delete("/{code}")
    @RolesAllowed("ROLE_REMOVE_PERSON")
    fun delete(@PathVariable code: Long): HttpResponse<Void> {

        personService.delete(code)
        return HttpResponse.noContent()
    }

    private fun toUri(code: Long?): URI? {
        return URI.create("/api/persons/${code}")
    }
}