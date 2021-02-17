package magnbred.ntnu.daoexample.daoExample.service;

import magnbred.ntnu.daoexample.daoExample.model.Employee;
import magnbred.ntnu.daoexample.daoExample.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    public int addEmployee(Employee employee){
        employeeRepo.addEmployee(employee);
        logger.info("Added employee to database: " + employee.toString());
        return 1;
    }

    public Employee getEmployee(Long id){
        Employee e = employeeRepo.getEmployee(id);
        logger.info("Retrieved employee with id: " + id + "\n" + e.toString());
        return e;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeRepo.getAllEmployees();

        StringBuilder loggerMsg = new StringBuilder();
        employees.stream().forEach(employee -> loggerMsg.append(employee.toString() + "\n"));

        logger.info("Retrieving all employees: \n" + loggerMsg.toString());

        return employees;
    }

    public void update(Employee employee, Long id){
        logger.info("Updating employee with id: " + id + "\nToo: " + employee.toString());

        employeeRepo.updateEmployee(employee, id);
    }

    public void deleteEmployee(String firstName, String lastName) {
        logger.info("Deleting employee with the name: " + firstName + " " + lastName);

        employeeRepo.deleteEmployee(firstName, lastName);
    }
}
