package vn.techmaster;

import java.util.ArrayList;

public class DBAccount {
    public static ArrayList<Customer> dbCustomer = new ArrayList<Customer>();
    public static ArrayList<Employee> dbEmployee = new ArrayList<Employee>();
    public static ArrayList<Admin> dbAdmin = new ArrayList<Admin>();

    static {
        dbCustomer.add(new Customer(1,10,Role.CUSTOMER,"abc","abc@gmail.com"));
        dbCustomer.add(new Customer(2,20,Role.CUSTOMER,"abc","abc@gmail.com"));
        dbCustomer.add(new Customer(3,30,Role.CUSTOMER,"abc","abc@gmail.com"));
    }

    static {
        dbEmployee.add(new Employee(1,10,Role.EMPLOYEE,"abc","abc@gmail.com",10));
        dbEmployee.add(new Employee(2,20,Role.EMPLOYEE,"abc","abc@gmail.com",10));
        dbEmployee.add(new Employee(3,30,Role.EMPLOYEE,"abc","abc@gmail.com",10));
    }

    static {
        dbAdmin.add(new Admin(1,10,Role.EMPLOYEE,"abc","abc@gmail.com",10,10));
        dbAdmin.add(new Admin(2,20,Role.EMPLOYEE,"abc","abc@gmail.com",10,10));
        dbAdmin.add(new Admin(3,30,Role.EMPLOYEE,"abc","abc@gmail.com",10,10));
    }
}
