package fr.dta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeMockRepository;
import fr.dta.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeMockService implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeMockRepository;

	
	public EmployeeRepository getDepend() {
		return employeeMockRepository;
	}

	public void setDepend(EmployeeMockRepository employeeMockRepository) {
		this.employeeMockRepository = employeeMockRepository;
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeMockRepository.findAllEmployees();
	}

	public Employee findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public Employee findLastHired() {
		
		return employeeMockRepository.findAllEmployees().stream().filter(x -> x instanceof Employee).sorted((x1, x2) -> {
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
