package net.guides.springboot2.springboot2jpacrudexample.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import net.guides.springboot2.springboot2jpacrudexample.model.SubEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.SubEmployeeRepository;

//import static java.awt.AWTEventMulticaster.save;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController
{
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee SubEmployee;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
    {
       // List<Employee> l1=new ArrayList<Employee>();
        //l1.employeeRepository.findAll();
        //for(int i=0; i<=l1.size(); i++)
        //{
          //  System.out.println(l1.get(i));
        //}
       // final employee = l1.save(employee);
        return employeeRepository.findAll();
       // Employee employee;
       // final Employee employee = employeeRepository.save(employee);
    }
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException
	{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@GetMapping("/subemployee")
	public SubEmployee getAlEmployees() {
		SubEmployee subemployee = new SubEmployee();
		List<Employee> employee = employeeRepository.findAll();

		for (Employee element : employee) {
			subemployee.setId(element.getId());
			subemployee.setFirstName(element.getFirstName());

		}
		System.out.println(subemployee);
		//Employee SubEmployee;
		//SubEmployee = save(employee);
		return (net.guides.springboot2.springboot2jpacrudexample.model.SubEmployee) SubEmployee;

	}
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException
	{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException
	{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//int i;

   // List<Employee> lst =Employee.employeeRepository.findAll();
	//while(list!=0)
    //{
       // System.out.println(lst);
    //}
}

class SubEmployeeController extends EmployeeController
{

/*		 @Autowired
		 private EmployeeRepository subemployeeRepository;
	@GetMapping("/sub_employee")
	public List<Employee> getAllEmployees()
	{
		 return subemployeeRepository.findAll();
	}
	//getting employee id
	@GetMapping("/sub_employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException
	{
		Employee subemployee = subemployeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(subemployee);
	}
	@PutMapping("/subemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
												   @Valid @RequestBody Employee subemployeeDetails) throws ResourceNotFoundException
	{
		Employee subemployee = subemployeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		subemployee.setLastName(subemployeeDetails.getLastName());
		subemployee.setFirstName(subemployeeDetails.getFirstName());
		final Employee updatedEmployee = subemployeeRepository.save(subemployee);
		return ResponseEntity.ok(updatedEmployee);
	}
*/
}