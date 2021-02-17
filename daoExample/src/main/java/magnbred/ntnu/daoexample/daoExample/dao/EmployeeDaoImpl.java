package magnbred.ntnu.daoexample.daoExample.dao;

import magnbred.ntnu.daoexample.daoExample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int create(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee VALUES (?, ?, ?, ?, ?)", employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getPhone(), employee.getEmail());
    }

    @Override
    public Employee read(Long id) {
        String query = "SELECT * FROM employee WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employee";

        return jdbcTemplate.query(query, new EmployeeRowMapper());
    }

    @Override
    public void update(Employee employee, Long id) {
        String query = "UPDATE employee SET " +
                "FirstName = ?, " +
                "LastName = ?, " +
                "Phone = ?, " +
                "Email = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(), employee.getPhone(), employee.getEmail(), id);
    }

    @Override
    public void delete(String firstName, String lastName) {
        String query = "DELETE FROM employee WHERE FirstName = ? AND LastName = ?";
        jdbcTemplate.update(query, firstName, lastName);
    }
}
