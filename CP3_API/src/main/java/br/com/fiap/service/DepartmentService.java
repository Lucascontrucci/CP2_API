package br.com.fiap.service;

import br.com.fiap.entity.Department;
import br.com.fiap.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    public DepartmentService(@Autowired DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long departmentId, Department updatedDepartment) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            Department department1 = department.get();

            department1.setName(updatedDepartment.getName());

            departmentRepository.save(department1);

            return department1;
        }
        return null;
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}

