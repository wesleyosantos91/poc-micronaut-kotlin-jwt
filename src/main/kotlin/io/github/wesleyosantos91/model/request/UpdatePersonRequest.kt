package io.github.wesleyosantos91.model.request

import java.time.LocalDate

data class UpdatePersonRequest(
    val name: String,
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String
)