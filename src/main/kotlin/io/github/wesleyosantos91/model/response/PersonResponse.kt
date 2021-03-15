package io.github.wesleyosantos91.model.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class PersonResponse(
    val code: Long?,
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    val dateOfBirth: LocalDate,
    val cpf: String,
    val email: String?
)