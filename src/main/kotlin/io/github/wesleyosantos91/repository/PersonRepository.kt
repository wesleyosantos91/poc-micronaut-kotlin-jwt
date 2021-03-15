package io.github.wesleyosantos91.repository

import io.github.wesleyosantos91.model.entity.Person
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {
}