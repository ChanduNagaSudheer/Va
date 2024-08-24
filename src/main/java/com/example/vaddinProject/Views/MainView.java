package com.example.vaddinProject.Views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;



@Route("")
public class MainView extends AppLayout {

     public MainView(){




//         Button employeeListButton = new Button("Employee List");
//         employeeListButton.addClickListener(event -> employeeListButton.getUI().ifPresent(ui -> ui.navigate("getall")));
//         Button addEmployeeButton = new Button("Add Employee");
//         addEmployeeButton.addClickListener(event -> addEmployeeButton.getUI().ifPresent(ui -> ui.navigate("addemp")));
//         Button deleteEmployeeButton = new Button("Delete Employee");
//         deleteEmployeeButton.addClickListener(event -> deleteEmployeeButton.getUI().ifPresent(ui -> ui.navigate("delete")));
//
//         // Add buttons to a horizontal layout
//         HorizontalLayout navigationBar = new HorizontalLayout(employeeListButton, addEmployeeButton, deleteEmployeeButton);
         createHeader();
         createDrawer();
    }
    private void createHeader() {
        H1 logo = new H1("My Vaadin Application");
        logo.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        Button toggleButton = new Button("☰", e -> getElement().executeJs("this.toggleDrawer()"));
        toggleButton.getElement().setAttribute("aria-label", "Menu toggle");

        HorizontalLayout header = new HorizontalLayout(toggleButton, logo);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.getStyle().set("padding", "0 var(--lumo-space-m)").set("box-shadow", "var(--lumo-box-shadow-s)");

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink homeLink = new RouterLink("ADD-EMPLOYEE", EmpAdd.class);
        RouterLink addEmployeeLink = new RouterLink("GET-EMPLOYEES", Employees.class);
        RouterLink deleteEmployeeLink = new RouterLink("DELETE-EMPLOYEE", DeleteEmployee.class);

        addToDrawer(new VerticalLayout(
                homeLink,
                addEmployeeLink,
                deleteEmployeeLink
        ));
    }

}
