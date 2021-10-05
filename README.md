Configuração de ambiente (application.proprities):

<code> ring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
app.datasource.springdatajpademo.url=jdbc:mysql://${DB_WINE_HOST}:${DB_WINE_PORT}/${DB_WINE_DATABASE}?useTimezone=true&serverTimezone=GMT&useSSL=true
app.datasource.springdatajpademo.username=${DB_WINE_USERNAME}
app.datasource.springdatajpademo.password=${DB_WINE_PASSWORD}
server.servlet.contextPath=/api/
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect </code>

<p> DB_WINE_HOST: localhost (acesso local) </p>
<p> DB_WINE_PORT: porta do seu banco de acesso local </p>
<p> DB_WINE_DATABASE: wine </p>
<p> DB_WINE_USERNAME: username do seu banco local </p>
<p> DB_WINE_PASSWORD: password do seu banco local </p>

Script MySQL:

CREATE TABLE `CEP` (
`ID` INT NOT NULL AUTO_INCREMENT,
`CODIGO_LOJA` VARCHAR(30) NOT NULL,
`FAIXA_INICIO` BIGINT NOT NULL,
`FAIXA_FIM` BIGINT NOT NULL,
PRIMARY KEY(`ID`)
);


Versão: 
Java 11
