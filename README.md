# sofia
Proyecto de caja de  cajas de ahorro (Proyecto de vinculación)
 
`Sofia` Software donde se redireccionara las peticiones 200 y acojer todos los registros generados por sofia-frontEnd 

## Software requerido
- JDK 1.8.0_121
- Apache Maven 3.5.3
- PostgreSQL 11.1-1

## Pasos previos
- [Instalar y configurar Maven](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)
## Instalación
`generados` puede ser ejecutado como una aplicación Spring-Boot la cual requiere la instalación previa de PostgreSQL.

### Despliegue estándar

1. Abrir una consola o shell y crear la base de datos.
```bash
$ psql -U postgres
# CREATE DATABASE "sofia-db";
# \q
```
2. Ejecuta spring boot ya que cuenta con la capa ddl-auto

3. Si deseas cambiar ala version de docker 

```
spring.datasource.url=jdbc:postgresql://dbpostgresql-db/sofia-api
spring.datasource.username=postgres
spring.datasource.password=XaviNoob2016
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jackson.default-property-inclusion=non-null
server.port = 80
```
 

4. Si desea ejecutar local 

```
spring.datasource.url=jdbc:postgresql://localhost:5432/sofia
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jackson.default-property-inclusion=non-null
```

