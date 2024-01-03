package com.example.JPARestCrud.res;

import com.example.JPARestCrud.entity.Employee;
import com.example.JPARestCrud.exception_handler.EmployeeNotFountExp;
import com.example.JPARestCrud.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeResController {

    private EmployeeServiceImpl employeeService;


    @Autowired
    public EmployeeResController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee>findAll(){

        return  employeeService.findAll();
    }


    @PostMapping("/employees")
    public Employee save(Employee employee){

        return  employeeService.save(employee);
    }

    @GetMapping("/employees/{id}")
    public  Employee findById(@PathVariable int id){

        return  employeeService.findById(id);
    }


    @DeleteMapping("/employees/{id}")
    public  String deleteById(@PathVariable int id){

        Employee employee = employeeService.findById(id);

        System.out.print("\n"+employee+"\n");

        if(employee ==null){

            throw  new EmployeeNotFountExp("Employee id not found");

        }

        employeeService.deleteById(employee.getId());

        return  "Delete "+employee.getId();


    }


    @PutMapping("/employees")
    public  Employee update(@RequestBody Employee employee){

        Employee employee1=employeeService.findById(employee.getId());

        if(employee.getFirstName().isEmpty()){
            employee1.setFirstName(employee1.getFirstName());
        }else {

            employee1.setFirstName(employee.getFirstName());
        }


        if(employee.getLastName().isEmpty()){
            employee1.setLastName(employee1.getLastName());
        }else {

            employee1.setLastName(employee.getLastName());
        }


        if(employee.getEmail().isEmpty()){
            employee1.setEmail(employee1.getEmail());
        }else {

            employee1.setEmail(employee.getEmail());
        }




        return  employeeService.save(employee1);
    }

}
