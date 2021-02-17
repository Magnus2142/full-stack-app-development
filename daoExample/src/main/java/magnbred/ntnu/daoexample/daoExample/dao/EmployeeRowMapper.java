package magnbred.ntnu.daoexample.daoExample.dao;

import magnbred.ntnu.daoexample.daoExample.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("FirstName"));
        employee.setLastName(rs.getString("LastName"));
        employee.setPhone(rs.getString("Phone"));
        employee.setEmail(rs.getString("Email"));

        return employee;
    }
}
