package com.example.vaddinProject.Views;


import com.example.vaddinProject.Model.Employee;
import com.example.vaddinProject.Service.EmployeeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "addemp",layout =MainView.class)
@PageTitle("Employee_ADD")
public class EmpAdd extends FormLayout {
    TextField Company=new TextField("Enter the Company");
    TextField Location=new TextField("Enter the Location");
    TextField name=new TextField("Enter name");
    CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
    Button btnSave=new Button("Save");
    @Autowired
    public EmployeeService employeeService;
    public EmpAdd(){
        setPreference();
         add(name,Company,Location,checkboxGroup);
         btnSave.addClickListener(e->{
             employeeService.AddEmployee(new Employee(Company.getValue(),Location.getValue(),name.getValue(),checkboxGroup.getSelectedItems().stream().toList()));
             Notification nf= Notification.show("Employee Added successfully");
         });
         add(btnSave);

    }
    public void setPreference(){
        checkboxGroup.setItems("Hyderabad","Chennai","Bengalore");
        checkboxGroup.setLabel("Preference");
    }
}
