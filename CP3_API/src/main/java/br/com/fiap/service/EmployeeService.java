package br.com.fiap.service;


import br.com.fiap.entity.Employee;
import br.com.fiap.repository.DepartmentRepository;
import br.com.fiap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            Employee employee1 = employee.get();

            employee1.setName(updatedEmployee.getName());
            employee1.setTitle(updatedEmployee.getTitle());
            employee1.setSalary(updatedEmployee.getSalary());
            employee1.setManager(updatedEmployee.getManager());
            employee1.setDepartment(updatedEmployee.getDepartment());

            if (updatedEmployee.getDepartment() != null) {
                employee1.setDepartment(updatedEmployee.getDepartment());
            }

            employeeRepository.save(employee1);

            return employee1;
        }
        return null;
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> findEmployeesBySalary(double minSalary, double maxSalary) {
        return employeeRepository.findEmployeesBySalary(minSalary, maxSalary);
    }

    public List<Object[]> findAverageSalary() {
        return employeeRepository.findAverageSalary();
    }

}

