package vn.techmaster;

import java.util.Scanner;

public class Employee extends Account implements IEmployee {
    private double salary;
    Admin admin = new Admin();
    @Override
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Input new Employee: ID, Balance, Name, Email, Salary");
        employee.setId(Integer.parseInt(scanner.nextLine()));       // Chong troi lenh
        employee.setBalance(Double.parseDouble(scanner.nextLine()));  // Chong troi lenh
        employee.setRole(Role.EMPLOYEE);
        employee.setName(scanner.nextLine());
        employee.setEmail(scanner.nextLine());
        employee.setSalary(Double.parseDouble(scanner.nextLine()));
        if(admin.approvalNewEmployee(employee)){
            System.out.println("Add new Employee: Success");
        }else
        {
            System.out.println("Add new Employee: Fail");
        }
    }

    @Override
    public int getAccountByID(int id) {
        System.out.println("Employee getAccountByID");
        return 0;
    }

    @Override
    public void checkBalance(){
        System.out.println("Employee check Balance");
    }


    public boolean requestNewCustomer(Customer customer){
        System.out.println("ID: " + customer.getId());
        System.out.println("Balance: " + customer.getBalance());
        System.out.println("Role: " + customer.getRole());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        if( admin.approvalNewCustomer(customer))
        {
            System.out.println("Request is approval");
            return true;
        } else{
            System.out.println("Not Approval");
            return false;
        }
    }


    public Employee(int id, double balance, Role role, String name, String email, double salary) {
        super(id, balance, role, name, email);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Employee() {

    }
}
