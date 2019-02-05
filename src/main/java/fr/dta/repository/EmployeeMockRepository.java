package fr.dta.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import fr.dta.modele.Employee;

@Repository
public class EmployeeMockRepository implements EmployeeRepository {

	private List<Employee> listeEmp;

	public EmployeeMockRepository() {
		listeEmp = new ArrayList<Employee>();

	}

	@PostConstruct
	public void init() {
		Employee e1 = new Employee( "Benji", "Montet", "0123456789", new BigDecimal(25000.0),
				LocalDate.of(2019, Month.JANUARY, 1));
		Employee e2 = new Employee("Benjimet", "Montet", "0123456798", new BigDecimal(26000.0),
				LocalDate.of(2017, Month.JANUARY, 1));
		Employee e3 = new Employee("Benjimot", "Montet", "0123456987", new BigDecimal(27000.0),
				LocalDate.of(2018, Month.JANUARY, 1));
		listeEmp.add(e1);
		listeEmp.add(e2);
		listeEmp.add(e3);
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	public List<Employee> findAllEmployees() {
		return listeEmp;
	}

	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAllEmployee(List<Employee> listEmpl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
