package magnbred.ntnu.daoexample.daoExample.repo;


import magnbred.ntnu.daoexample.daoExample.dao.EmployeeDaoImpl;
import magnbred.ntnu.daoexample.daoExample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    public int addEmployee(Employee employee){
        employeeDao.create(employee);
        return 1;
    }

    public Employee getEmployee(Long id){
        return employeeDao.read(id);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public void updateEmployee(Employee employee, Long id){
        employeeDao.update(employee, id);
    }

    public void deleteEmployee(String firstName, String lastName){
        employeeDao.delete(firstName, lastName);
    }
}
