package io.github.wesleyosantos91.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
@Introspected
data class User(

    @Id
    @Column(name = "code")
    var code: Long?,

    @Column(name = "name")
    var name: String,

    @Email
    @Column(name = "email")
    var email: String,

    @JsonIgnore
    @Column(name = "password")
    @Size(min = 6)
    val password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_users",
        joinColumns = [JoinColumn(name = "user_code")],
        inverseJoinColumns = [JoinColumn(name = "role_code")]
    )
    val roles: List<Role>,

)