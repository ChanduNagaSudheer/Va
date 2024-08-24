package com.example.vaddinProject.Views;

import com.example.vaddinProject.Service.EmployeeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route(value = "delete",layout = MainView.class)
@PageTitle("Delete employee")
public class DeleteEmployee extends VerticalLayout {
    Button btndel=new Button("Delete Employee By Id");
    NumberField IDtoDelete=new NumberField("Enter the Id to delete");
    @Autowired
    public EmployeeService employeeService;
    public DeleteEmployee(){
        add(IDtoDelete,btndel);
        btndel.addClickListener(e-> {
              employeeService.deleteEmployee(IDtoDelete.getValue().intValue());
            Notification nf= Notification.show("Employee Deleted Succefully");
        });
    }
}
