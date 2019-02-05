package fr.dta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.EmployeeJpaService;
import fr.dta.service.EmployeeService;
import fr.dta.service.EntrepriseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class EmployeeTest {

	@Autowired
	EntrepriseService entrepriseService;
	
	@Autowired
	EmployeeRepository employeeJpaRepository;
	
	@Autowired
	EmployeeService employeeJpaService;



	@Test
	public void testSave() throws Exception {

		employeeJpaService.delete();
		
		Employee e3 = new Employee("Benjamin", "Montet", "0123456987", new BigDecimal(2500.0),
				LocalDate.of(2018, Month.JANUARY, 1));
		Employee e4 = new Employee( "Baptiste", "Carreaux", "0231564789", new BigDecimal(2800.0),
				LocalDate.of(2017, Month.JANUARY, 1));
		Employee e5 = new Employee( "Elie", "Rouer", "0147852369", new BigDecimal(2650.0),
				LocalDate.of(2019, Month.JANUARY, 1));
		employeeJpaService.saveEmployee(e3);
		employeeJpaService.saveEmployee(e4);
		employeeJpaService.saveEmployee(e5);

		for (Employee e : employeeJpaService.findAllEmployees()) {
			System.out.println(e.toString());
		}

		System.out.println("\n avec l'ssn (vrai): " + employeeJpaService.findBySsn("0123456987")+"\n");
		
		try{
			System.out.println("\n avec l'ssn (faux): " + employeeJpaService.findBySsn("0123456789")+"\n");
		}
		catch(Exception e) {
			
		}
		e3.setNom("GNAR");
		System.out.println("\n test du set : " + e3+"\n");
		employeeJpaService.updateEmployee(e3);
		System.out.println("\n e3 modifié : " + employeeJpaService.findBySsn("0123456987")+"\n");

		List<Employee> listEmpl = new ArrayList<>();
		listEmpl.add(e3);
		listEmpl.add(e5);
		listEmpl.add(e4);
		Employee e6 = new Employee("test", "test", "0125485934", new BigDecimal(2650.0),
				LocalDate.of(2019, Month.JANUARY, 1));
		listEmpl.add(e6);

		employeeJpaService.updateAllEmployee(listEmpl);

	}
}