package fr.dta.service;

import java.util.List;

import fr.dta.modele.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);

	Employee findLastHired();
	
	void delete();

	void updateAllEmployee(List<Employee> listEmpl);
}