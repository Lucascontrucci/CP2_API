package br.com.fiap.controller;

import br.com.fiap.entity.Department;
import br.com.fiap.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Tag(name = "Departments",description = "CRUD DE DEPARTAMENTOS")
public class DepartmentController{
    private final DepartmentService departmentService;


    public DepartmentController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/Name")
    public Department findDepartmentByName(@RequestParam("name") String name) {
        return departmentService.findByName(name);
    }
}
