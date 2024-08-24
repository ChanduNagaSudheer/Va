package com.example.vaddinProject.Service;


import com.example.vaddinProject.Model.Employee;
import com.example.vaddinProject.Repository.EmplyeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
      @Autowired
      public EmplyeeRepo emprepo;


      public List<Employee> getAllEmployess(){
          return emprepo.findAll();
      }

      public Employee AddEmployee(@RequestBody Employee emp ){
          emprepo.save(emp);
          return emp;
      }

      public Employee GetEmployeebyId(@PathVariable int id){
         Optional<Employee> emp_with_id=emprepo.findById(id);
         return emp_with_id.get();
      }


    public Employee UpdateEmployeebyId(@PathVariable int id,@RequestBody Employee emppp){
        Optional<Employee> emp_with_id=emprepo.findById(id);
        Employee empp=emp_with_id.get();
        empp.setCompany(emppp.getCompany());
        empp.setName(emppp.getName());
        empp.setLocation(emppp.getLocation());
        empp.setPreference(emppp.getPreference());
        emprepo.save(empp);
        return empp;
    }

    public String deleteEmployee(@PathVariable int id){
          emprepo.deleteById(id);
          return "Successfully deleted Employee";
    }
}

