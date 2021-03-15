package io.github.wesleyosantos91.model.request

import java.time.LocalDate

data class CreatePersonRequest (
    val name: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String

)