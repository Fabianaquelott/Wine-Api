 <h1> 🍷 Configuração de ambiente (application.proprities):</h1>

<code> ring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
app.datasource.springdatajpademo.url=jdbc:mysql://${DB_WINE_HOST}:${DB_WINE_PORT}/${DB_WINE_DATABASE}?useTimezone=true&serverTimezone=GMT&useSSL=true
app.datasource.springdatajpademo.username=${DB_WINE_USERNAME}
app.datasource.springdatajpademo.password=${DB_WINE_PASSWORD}
server.servlet.contextPath=/api/
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect </code>

<h3>PT:</h3>
<p> DB_WINE_HOST: localhost (acesso local) </p>
<p> DB_WINE_PORT: porta do seu banco de acesso local </p>
<p> DB_WINE_DATABASE: wine </p>
<p> DB_WINE_USERNAME: username do seu banco local </p>
<p> DB_WINE_PASSWORD: password do seu banco local </p>

<h3>EN:</h3>
<p> DB_WINE_HOST: localhost (local acess) </p>
<p> DB_WINE_PORT: port of your local access bank </p>
<p> DB_WINE_DATABASE: wine </p>
<p> DB_WINE_USERNAME: username of your local database </p>
<p> DB_WINE_PASSWORD: password of your local database </p>

Script MySQL:

CREATE TABLE `CEP` (
<p> `ID` INT NOT NULL AUTO_INCREMENT, </p> 
<p> `CODIGO_LOJA` VARCHAR(30) NOT NULL, </p> 
<p> `FAIXA_INICIO` BIGINT NOT NULL, </p> 
<p> `FAIXA_FIM` BIGINT NOT NULL, </p> 
<p> PRIMARY KEY(`ID`) </p> 
); <p> 



Versão: 
Java 11
