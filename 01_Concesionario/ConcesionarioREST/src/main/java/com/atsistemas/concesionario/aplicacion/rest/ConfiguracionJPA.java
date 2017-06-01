package com.atsistemas.concesionario.aplicacion.rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

// Etiqueta necesaria para que se entienda esta calase como un bean de configuracion
@Configuration
// Etiqueta necesaria para que reconozca los beans de jpa que se han creado
// y que indica la ruta en la que se encuentran las interfaces que extienden de JpaRepository
@EnableJpaRepositories(basePackages="com.atsistemas.concesionario.persistencia.jpa")
public class ConfiguracionJPA {
	
	// A pesar de no usar la etiqueta @Transactional es necesario crear un bean Manager de Transacciones
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	// Creación del DataSource
	// Esta etiqueta se encuentra dentro del context (Spring)
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:derby://localhost:1527/dbtest;create=true");
		basicDataSource.setUsername("admin");
		basicDataSource.setPassword("admin");
		// Driver para la conexión a Derby
		basicDataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		return basicDataSource;
	}
	
	//Configuracion de la generación y tratamiento de los elementos en bbdd
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource);

		entityManagerFactoryBean.setPackagesToScan("com.atsistemas.concesionario.entidadesJPA");

		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		// properties.setProperty("hibernate.current_session_context_class", "thread");
		
		// Si no deseamos que se genere la bbdd cada vez que arrancamos la aplicacion es necesario poner update
		//properties.setProperty("hibernate.hbm2ddl.auto", "create");
		//properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		entityManagerFactoryBean.setJpaProperties(properties);

		return entityManagerFactoryBean;
	}

//	@Bean
//	public PropertyPlaceholderConfigurer properties(){
//		PropertyPlaceholderConfigurer placeholderConfigurer 
//								= new PropertyPlaceholderConfigurer();
//		
//		placeholderConfigurer.setLocation(
//				new ClassPathResource("Configuracion.properties"));
//		
//		return placeholderConfigurer;
//	}
	
	
}
