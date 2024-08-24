package com.example.vaddinProject.Controller;


import com.example.vaddinProject.Model.Employee;
import com.example.vaddinProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    @GetMapping("/employees")
    private ResponseEntity<List<Employee>> getall(){
       if(empservice.getAllEmployess().size()>0) return new ResponseEntity<>(empservice.getAllEmployess(), HttpStatus.OK);
       else return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/{id}")
    private ResponseEntity<Employee> getEmp(@PathVariable int id){
        if(empservice.GetEmployeebyId(id)!=null) return new ResponseEntity<>(empservice.GetEmployeebyId(id), HttpStatus.OK);
        else return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees/add")
    private ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
        return new ResponseEntity<>(empservice.AddEmployee(emp),HttpStatus.OK);
    }

    @PostMapping("/employees/{id}")
    private ResponseEntity<Employee> updateEmp(@PathVariable int id,@RequestBody Employee emp){
        return new ResponseEntity<>(empservice.UpdateEmployeebyId(id,emp),HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{id}")
    private ResponseEntity<String> deletebyId(@PathVariable int id){
        return new ResponseEntity<>(empservice.deleteEmployee(id),HttpStatus.OK);
    }


}
