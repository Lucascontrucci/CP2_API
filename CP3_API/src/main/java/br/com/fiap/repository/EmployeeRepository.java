package br.com.fiap.repository;

import br.com.fiap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findEmployeesBySalary(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);

    @Query(value = "SELECT d.name AS departmentName, AVG(e.salary) AS averageSalary " +
            "FROM Employee e " +
            "JOIN Department d ON e.department_id = d.id " +
            "GROUP BY d.name",
            nativeQuery = true)
    List<Object[]> findAverageSalary();
}

