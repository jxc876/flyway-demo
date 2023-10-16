package com.demo

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import io.micronaut.runtime.Micronaut.run
import java.util.UUID

@MappedEntity("person")
data class Person(
	@field:Id @AutoPopulated
	val id: UUID = UUID.randomUUID(),
	val name: String,
	val company: String
)

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PeopleRepository: CrudRepository<Person, UUID> {}

fun main(args: Array<String>) {
	println("**** START ****")
	val context = run(*args)
	val repo = context.getBean(PeopleRepository::class.java)
	repo.save(Person(name = "mike", company = "Target"))
	println("**** DONE ****")
}

