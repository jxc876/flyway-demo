## Flyway demo

Simple App to showcase Flyway migrations:

```kt
@MappedEntity("person")
data class Person(
	@field:Id @AutoPopulated
	val id: UUID = UUID.randomUUID(),
	val name: String,
	val company: String
)
```

Refer to [migration](./src/main/resources/db/migration) folder:

```
V1__initial.sql
V2__AddColumn.sql
```

and `application.yml`:

```yaml
flyway:
  datasources:
    default:
      enabled: true # true | false
      baseline-on-migrate: true
```
