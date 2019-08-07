package com.balti.restaurant.sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balti.restaurant.sys.entities.Customer;
import com.balti.restaurant.sys.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
