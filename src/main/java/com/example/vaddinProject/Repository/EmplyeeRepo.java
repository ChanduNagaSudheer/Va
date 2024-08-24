package com.example.vaddinProject.Repository;

import com.example.vaddinProject.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplyeeRepo extends JpaRepository<Employee,Integer> {
}
