package magnbred.ntnu.daoexample.daoExample.dao;

import magnbred.ntnu.daoexample.daoExample.model.Employee;

import java.util.List;

public interface EmployeeDao {
    int create(Employee employee);
    Employee read(Long id);
    void update(Employee employee, Long id);
    void delete(String firstName, String lastName);
    List<Employee> getAllEmployees();
}
