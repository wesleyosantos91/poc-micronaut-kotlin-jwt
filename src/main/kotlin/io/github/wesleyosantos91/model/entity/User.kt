package io.github.wesleyosantos91.model.entity

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "user")
@Introspected
data class User(

    @Id
    val cpf: String,
    @Column
    @Size(min = 6)
    val password: String,
)