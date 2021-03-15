package io.github.wesleyosantos91.model.entity

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(name = "person")
@Introspected
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    var code: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "data_nascimento")
    var dataOfBirth: LocalDate,

    @Column(name = "cpf")
    var cpf: String,

    @Email
    @Column(name = "email")
    var email: String,
)