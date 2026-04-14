package com.example.spring;
import org.springframework.stereotype.*; @Component
public class Employee {
private String name = "Arjun Kumar"; private String department = "CSE"; private double salary = 75000.0;
public String getName()	{ return name; }
public String getDepartment() { return department; } public double getSalary()	{ return salary; }
public String toString() {
return "Employee{" + name + ", " + department + ", " + salary + "}";
}
}
// EmployeeService.java @Component
public class EmployeeService { @Autowired
private Employee employee; public void displayEmployee() {
System.out.println("Employee Details: " + employee);
}
}
// AppConfig.java
import org.springframework.context.annotation.*;
 
@Configuration @ComponentScan("com.example.spring") public class AppConfig {}
// MainApp.java
import org.springframework.context.*;
import org.springframework.context.annotation.*; public class MainApp {
public static void main(String[] args) { ApplicationContext ctx =
new AnnotationConfigApplicationContext(AppConfig.class); EmployeeService svc = ctx.getBean(EmployeeService.class); svc.displayEmployee();
}
}
