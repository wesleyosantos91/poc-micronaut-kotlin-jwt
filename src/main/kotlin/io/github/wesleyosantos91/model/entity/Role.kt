package io.github.wesleyosantos91.model.entity

import io.micronaut.core.annotation.Introspected
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "roles")
@Introspected
data class Role(
    @Id
    @Column(name = "code")
    var code: Long?,

    @Column(name = "description")
    var description: String
)