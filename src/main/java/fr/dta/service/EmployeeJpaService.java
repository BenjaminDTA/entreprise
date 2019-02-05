package fr.dta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeJpaService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeJpaRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeJpaRepository.saveEmployee(employee);

	}

	@Override
	public void delete() {
		employeeJpaRepository.delete();
	}

	@Override
	public List<Employee> findAllEmployees() {

		return employeeJpaRepository.findAllEmployees();
	}

	@Override
	public Employee findBySsn(String ssn) {
		return employeeJpaRepository.findBySsn(ssn);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeJpaRepository.updateEmployee(employee);

	}

	@Override
	public Employee findLastHired() {
		return employeeJpaRepository.findAllEmployees().stream().filter(x -> x instanceof Employee).sorted((x1, x2) -> {
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
	public void updateAllEmployee(List<Employee> listEmpl) {
		employeeJpaRepository.updateAllEmployee(listEmpl);

	}


}
