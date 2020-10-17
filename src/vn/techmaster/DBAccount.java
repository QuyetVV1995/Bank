package vn.techmaster;

import java.util.ArrayList;

public class DBAccount {
    public static ArrayList<Customer> dbCustomer = new ArrayList<Customer>();
    public static ArrayList<Employee> dbEmployee = new ArrayList<Employee>();
    public static ArrayList<Admin> dbAdmin = new ArrayList<Admin>();

    static {
        dbCustomer.add(new Customer(1,10,Role.CUSTOMER,"customer1","customer1@gmail.com",0,0,0));
        dbCustomer.add(new Customer(2,20,Role.CUSTOMER,"customer2","customer2@gmail.com",0,0,0));
        dbCustomer.add(new Customer(3,30,Role.CUSTOMER,"customer3","customer3@gmail.com",0,0,0));
    }

    static {
        dbEmployee.add(new Employee(1,10,Role.EMPLOYEE,"employee1","employee1@gmail.com",10));
        dbEmployee.add(new Employee(2,20,Role.EMPLOYEE,"employee2","employee2@gmail.com",10));
        dbEmployee.add(new Employee(3,30,Role.EMPLOYEE,"employee3","employee3@gmail.com",10));
    }

    static {
        dbAdmin.add(new Admin(1,10,Role.EMPLOYEE,"admin1","admin1@gmail.com",10,10));
        dbAdmin.add(new Admin(2,20,Role.EMPLOYEE,"admin2","admin2@gmail.com",10,10));
        dbAdmin.add(new Admin(3,30,Role.EMPLOYEE,"admin3","admin3@gmail.com",10,10));
    }
}
