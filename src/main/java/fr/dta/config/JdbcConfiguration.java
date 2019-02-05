package fr.dta.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:application.properties")
public class JdbcConfiguration {

//	@Autowired
//	private Environment environment;
//
////	@PersistenceContext
////	private EntityManager em;
//
//	@Bean(name = "dataSource")
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//		return dataSource;
//	}
//
//	@Bean
//	public PlatformTransactionManager txManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
//
//	
}
