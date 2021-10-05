package com.wine.config;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.wine.repository")
class ApplicationConfig {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.springdatajpademo")
	public DataSourceProperties getDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.springdatajpademo.configuration")
	public DataSource getDataSource() {
		return getDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
}
