package br.com.fiap.controller;

import br.com.fiap.entity.Department;
import br.com.fiap.entity.Employee;
import br.com.fiap.service.DepartmentService;
import br.com.fiap.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee",description = "CRUD DE EMPLOYEE")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;


    public EmployeeController(@Autowired EmployeeService employeeService, @Autowired DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/salary-range")
    public List<Employee> findEmployeesInSalaryRange(@RequestParam("minSalary") double minSalary, @RequestParam("maxSalary") double maxSalary) {
        return employeeService.findEmployeesBySalary(minSalary, maxSalary);
    }

    @GetMapping("/average-salary-by-department")
    public List<Object[]> findAverageSalaryByDepartment() {
        return employeeService.findAverageSalary();
    }

}

