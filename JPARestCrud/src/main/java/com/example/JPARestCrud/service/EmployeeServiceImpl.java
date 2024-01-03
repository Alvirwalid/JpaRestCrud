package com.example.JPARestCrud.service;

import com.example.JPARestCrud.dao.EmployeeRepository;
import com.example.JPARestCrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {


        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee>result= employeeRepository.findById(id);

        Employee theEmployee=null;

        if(result.isPresent()){
            theEmployee=result.get();
        }else {

            throw  new RuntimeException("Employee id not found - "+id);
        }


        return theEmployee;
    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);

    }
}
