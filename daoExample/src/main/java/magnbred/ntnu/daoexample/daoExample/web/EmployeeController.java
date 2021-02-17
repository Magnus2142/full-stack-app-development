package magnbred.ntnu.daoexample.daoExample.web;

import magnbred.ntnu.daoexample.daoExample.model.Employee;
import magnbred.ntnu.daoexample.daoExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/employees")
    public int addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return 1;
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.update(employee, id);
    }

    @DeleteMapping("/employees/firstName={firstName}&lastName={lastName}")
    public void deleteEmployee(@PathVariable String firstName, @PathVariable String lastName){
        employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
