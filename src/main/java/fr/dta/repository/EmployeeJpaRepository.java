package fr.dta.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;
import fr.dta.modele.Entreprise;

@Repository
@Transactional
public class EmployeeJpaRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

	@Override
	protected Class<Employee> getEntityClass() {
		return Employee.class;
	}

	@Transactional(readOnly = true)
	public Optional<Employee> findOneByLogin(String login) {
		Employee user = (Employee) getSession().createCriteria(entityClass).add(Restrictions.eq("login", login))
				.uniqueResult();
		return Optional.of(user);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllByCompany(Entreprise company) {
		return getSession().createCriteria(entityClass).add(Restrictions.eq("company", company)).list();
	}

	@SuppressWarnings("finally")
	@Override
	public Employee findBySsn(String ssn) {
		try {
			TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.numeroSecu = :numeroSecu", Employee.class);
			return query.setParameter("numeroSecu", ssn).getSingleResult();
		}
		catch(NoResultException e) {
			throw new EmployeeNotFoundException("l'employee avec l'ssn : "+ssn+" n'existe pas");
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		update(employee);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateAllEmployee(List<Employee> employees) {
		try {
			for (Employee e : employees) {
				if (this.findAllEmployees().contains(e))
					updateEmployee(e);
				else {
					throw new EmployeeNotFoundException("l'employee n'existe pas");
				}
			}
		} catch (Exception message) {
			System.out.println("je suis dans le catch");
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		save(employee);
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		return findAll();
	}

	@Override
	public void delete() {
		em.createQuery("delete from Employee").executeUpdate();		
	}
	
	public void deleteOne(Employee e) {
		delete(e);
	}

}
