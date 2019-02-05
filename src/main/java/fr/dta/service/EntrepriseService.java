package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;

@Service
@Transactional
public class EntrepriseService {

	@Autowired
	private EmployeeService employeeMockService;

	public List<Employee> findEmployees() {
		return employeeMockService.findAllEmployees();
	}

}
