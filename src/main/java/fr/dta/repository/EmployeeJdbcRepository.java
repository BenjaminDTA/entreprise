package fr.dta.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;

@Repository
@Transactional
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	
	
	@Override
	public void saveEmployee(Employee employee) {
		this.getJdbcTemplate().update("insert into employee(firstname,hiredate,lastname,salary,ssn) values (?,?,?,?,?)",
				employee.getPrenom(), new Date(), employee.getNom(), employee.getSalaire(), employee.getNumeroSecu());
	}

	public void delete() {
		this.getJdbcTemplate().update("delete from employee;");
	}

	@Override
	public List<Employee> findAllEmployees() {
		return this.getJdbcTemplate().query("select * from employee", new EmployeeMapper());
	}

	@Override
	public Employee findBySsn(String ssn) {
		Employee employee = this.getJdbcTemplate().queryForObject("select * from employee where ssn=?",
				new Object[] { ssn }, new EmployeeMapper());
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee){
			this.getJdbcTemplate().update(
					"update employee set firstname=?, hiredate=?, lastname=?, salary=? where ssn=?",
					employee.getPrenom(),
					Date.from(employee.getDateEmbauche().atStartOfDay(ZoneId.systemDefault()).toInstant()),
					employee.getNom(), employee.getSalaire(), employee.getNumeroSecu());
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateAllEmployee(List<Employee> employees) {
		try {
			for (Employee e : employees) {
				if(this.findAllEmployees().contains(e))
					updateEmployee(e);
				else {
					throw new Exception();
				}
			}
		} catch (Exception message) {
			System.out.println("je suis dans le catch");
		}
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee(rs.getString("firstname"), rs.getString("lastname"),
					rs.getString("ssn"), rs.getBigDecimal("salary"),
					rs.getTimestamp("hiredate").toLocalDateTime().toLocalDate());
			return emp;
		}
	}

}
