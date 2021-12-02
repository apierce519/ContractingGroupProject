package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.model.Employee;


/**
 * @author Christian O'Brien - cpobrien3
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
