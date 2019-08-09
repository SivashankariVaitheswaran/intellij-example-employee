package net.guides.springboot2.springboot2jpacrudexample.repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.SubEmployee;

import java.util.List;

@Repository
public
interface SubEmployeeRepository extends JpaRepository<SubEmployee, Long>
{

    //static Object save(List<Employee> employee)
    //{
      //  return 1;
    //}
}
