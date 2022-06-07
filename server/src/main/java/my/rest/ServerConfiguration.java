package my.rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("my.rest.tables")
@ComponentScan({ "my.rest", "my.rest.restcontroller", "my.rest.service.impl", "my.rest.repository" })
@EnableJpaRepositories(entityManagerFactoryRef = "sessionFactory", transactionManagerRef = "transactionManager", basePackages = "my.rest.repository")
@EnableTransactionManagement
public class ServerConfiguration {

	@Autowired
	DataSource dataSource;

	@Value("${spring.datasource.driver-class-name}")
	String driverClassName;

	@Value("${spring.datasource.url}")
	String databaseUrl;

	@Value("${spring.datasource.username}")
	String username;

	@Value("${spring.datasource.password}")
	String password;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	String hbm2ddlAuto;

	@Value("${spring.jpa.properties.hibernate.dialect}")
	String hibernateDialect;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(
				new String[] { "my.rest.model.tables", "my.rest.repository", "my.rest.service.impl" });
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTransaction() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);
		return manager;
	}

	final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;
	}

}
