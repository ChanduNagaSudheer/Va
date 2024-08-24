package com.example.vaddinProject.Views;


import com.example.vaddinProject.Model.Employee;
import com.example.vaddinProject.Service.EmployeeService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


@Route("/Employee")
public class MainView extends VerticalLayout {
    @Autowired
     public EmployeeService employeeService;
    Grid<Employee> grid=new Grid<>(Employee.class);
    Button btn=new Button("Get All Employee Details");
    Button btnSave=new Button("Save");
    Button btndel=new Button("Delete Employee By Id");
    NumberField IDtoDelete=new NumberField("Enter the Id to delete");
    TextField Company=new TextField("Enter the Company");
    TextField Location=new TextField("Enter the Location");
    TextField name=new TextField("Enter name");
    CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
    public MainView(){

        Set();
        add(new HorizontalLayout(new VerticalLayout(Company,Location,name),checkboxGroup));
        add(btnSave);
        btnSave.addClickListener(e ->{
            AddEmployees();
            Notification nf=Notification.show("Employee Details Saved");
        });
        add(btn);
        add(IDtoDelete);
        add(btndel);
        btndel.addClickListener(e->{
            employeeService.deleteEmployee(IDtoDelete.getValue().intValue());
            ConfigureGrid();
            add(grid);
        });
        btn.addClickListener(e -> {
            ConfigureGrid();
            add(grid);
        });
    }
    public void ConfigureGrid(){
        grid.setItems(employeeService.getAllEmployess());
    }
    public void Set(){
        checkboxGroup.setLabel("Select Preferences");
        checkboxGroup.setItems("Hyderabad","Chennai","Bengalore");
    }
    public void AddEmployees(){
        Employee emp=new Employee(name.getValue(),Company.getValue(),Location.getValue(),new ArrayList<>(checkboxGroup.getSelectedItems()));
        employeeService.AddEmployee(emp);
    }

}
