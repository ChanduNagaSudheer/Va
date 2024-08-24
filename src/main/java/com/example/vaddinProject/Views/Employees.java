package com.example.vaddinProject.Views;

import com.example.vaddinProject.Model.Employee;
import com.example.vaddinProject.Service.EmployeeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "getall",layout = MainView.class)
@PageTitle("Employees Detaails")
public class Employees extends VerticalLayout {
    Grid<Employee> grid=new Grid<>(Employee.class);
    Button btn=new Button("Get All Employee Details");
    @Autowired
    public EmployeeService employeeService;
    public Employees(){
        add(btn);
        btn.addClickListener(e-> {
            configure();
            add(grid);
        });


    }
    public void configure(){
        grid.setItems(employeeService.getAllEmployess());
    }
}
