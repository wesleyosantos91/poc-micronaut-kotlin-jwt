package io.github.wesleyosantos91.service

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException
import io.github.wesleyosantos91.model.entity.Person
import io.github.wesleyosantos91.model.request.CreatePersonRequest
import io.github.wesleyosantos91.model.request.UpdatePersonRequest
import io.github.wesleyosantos91.model.response.PersonResponse
import io.github.wesleyosantos91.repository.PersonRepository
import javax.inject.Singleton

@Singleton
class PersonService(private val repository: PersonRepository) {

    fun findByAll(): List<PersonResponse> {
        return repository.findAll().map { p ->
            PersonResponse(p.code, p.name, p.dateOfBirth, p.cpf, p.email)
        }
    }

    fun findByCode(code: Long): PersonResponse {
        val (codeRes, name, dateOfBirth, cpf, email) = repository.findById(code)
            .orElseThrow { ObjectNotFoundException("Code $code not found") }
        return PersonResponse(code, name, dateOfBirth, cpf, email)
    }

    fun save(createPersonRequest: CreatePersonRequest): PersonResponse {

        val (code, name, dateOfBirth, cpf, email) = repository.save(
            Person(
                code = null,
                name = createPersonRequest.name,
                dateOfBirth = createPersonRequest.dateOfBirth,
                cpf = createPersonRequest.cpf,
                email = createPersonRequest.email
            )
        )

        return PersonResponse(code, name, dateOfBirth, cpf, email)

    }

    fun update(id: Long, updatePersonRequest: UpdatePersonRequest): PersonResponse {

        val personSaved = exist(id)

        personSaved.name = updatePersonRequest.name
        personSaved.dateOfBirth = updatePersonRequest.dateOfBirth
        personSaved.cpf = updatePersonRequest.cpf
        personSaved.email = updatePersonRequest.email

        val (code, name, dateOfBirth, cpf, email) = repository.update(personSaved)

        return PersonResponse(code, name, dateOfBirth, cpf, email)
    }

    fun delete(code: Long) {
        exist(code)
        repository.deleteById(code)
    }

    private fun exist(code: Long): Person {
        return repository.findById(code).orElseThrow { ObjectNotFoundException("Code $code not found") }
    }
}