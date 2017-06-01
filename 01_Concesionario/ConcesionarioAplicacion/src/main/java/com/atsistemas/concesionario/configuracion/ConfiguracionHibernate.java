package com.atsistemas.concesionario.configuracion;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

// Etiqueta necesaria para que se entienda esta clase como un bean de configuracion
@Configuration
// La creación de los beans mediante anotaciones se realiza con Spring
@ComponentScan({"com.atsistemas.concesionario.impl.persistencia.hibernate"})
public class ConfiguracionHibernate {
	
	
	//Al igual que en JPA es necesario tener un transaction manager, en este caso, de Hibernate
	// como en los DaoImpl se hace uso del sessionFactory se introduce con AutoInyeccion
	@Bean
	// @Autowired - Busca primero por nombre y luego por type, si tuviesemos varios bean del mismo elmento
	// habría que poner el @Qualifier(nombre del bean deseado)
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
	// Creación del DataSource
	// Esta etiqueta se encuentra dentro del context (Spring)
	@Bean
	/* Se realiza la obtencion de los valores de conexion de un fichero.properties*/
	public DataSource dataSource(
			@Value("${db.user}") String username, 
			@Value("${db.password}") String password, 
			@Value("${db.url}") String url, 
			@Value("${db.driver.class.name}") String driverClassName){
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	//Configuracion de la generación y tratamiento de los elementos en bbdd
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setDataSource(dataSource);

		sessionFactoryBean.setPackagesToScan("com.atsistemas.concesionario.entidadesHibernate");

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		properties.setProperty("hibernate.current_session_context_class", "thread");
		
		//Posibilidades a la hora de iniciar la conexion a BBDD
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		//properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		//properties.setProperty("hibernate.hbm2ddl.auto", "update");

		sessionFactoryBean.setHibernateProperties(properties);

		return sessionFactoryBean;
	}
	
	//Bean necesario para la inclusion del fichero de properties
	@Bean
	public PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer placeholderConfigurer 
								= new PropertyPlaceholderConfigurer();
		
		// Está en el mismo paquete, con señalar el nombre es suficiente
		// me imagino que se podrán poner varios properties
		// o variar el fichero seleccionado en función de las necesidades
		placeholderConfigurer.setLocation(
				new ClassPathResource("Configuracion.properties"));
		
		return placeholderConfigurer;
}

}
