package fr.dta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;

@Service
@Transactional
public class EmloyeeJdbcService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeJdbcRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeJdbcRepository.saveEmployee(employee);

	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeJdbcRepository.findAllEmployees();
	}

	@Override
	public Employee findBySsn(String ssn) {
		return employeeJdbcRepository.findBySsn(ssn);
	}

	@Override
	public void updateEmployee(Employee employee){
		employeeJdbcRepository.updateEmployee(employee);

	}

	@Override
	public Employee findLastHired() {
		return employeeJdbcRepository.findAllEmployees().stream().filter(x -> x instanceof Employee)
				.sorted((x1, x2) -> {
					Employee s1 = (Employee) x1;
					Employee s2 = (Employee) x2;
					if (s1.getDateEmbauche().isBefore(s2.getDateEmbauche())) {
						return 1;
					} else if (s1.getDateEmbauche().isAfter(s2.getDateEmbauche())) {
						return -1;
					}
					return 0;
				}).collect(Collectors.toList()).get(0);

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAllEmployee(List<Employee> listEmpl) {
		// TODO Auto-generated method stub
		
	}
}
