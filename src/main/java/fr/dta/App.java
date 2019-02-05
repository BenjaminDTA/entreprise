package fr.dta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.dta.config.AopConfiguration;


@Configuration
@ComponentScan(basePackages = "fr.dta")
@EnableAspectJAutoProxy
public class App {

	private static final  Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		logger.info("etst");
		

	}
}
