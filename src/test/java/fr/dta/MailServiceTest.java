package fr.dta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.modele.Employee;
import fr.dta.service.MailService;

public class MailServiceTest {
	
	@Test
	public void test() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		Employee e = new Employee("Benjimet", "Montet", "0123456798", new BigDecimal(26000.0),
				LocalDate.of(2017, Month.JANUARY, 1));
		MailService mailA = (MailService) context.getBean("mailService");
		mailA.setMessage("Test number FALLLCONNNNN");
		MailService mailB = (MailService) context.getBean("mailService");
		mailB.setMessage("Test number PPPUUNNNCCHHHH");

		mailA.sendMail(e);
		mailB.sendMail(e);
		//assertEquals(new String(mail.sendMail(new Employee())),"");
	}

}
