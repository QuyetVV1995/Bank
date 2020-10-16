package vn.techmaster;

import java.util.Scanner;

public class Customer extends Account implements ICustomer {

    Employee employee = new Employee();

    @Override
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Input new Customer: ID, Balance, Name, Email");
        customer.setId(Integer.parseInt(scanner.nextLine()));       // Chong troi lenh

        customer.setBalance(Double.parseDouble(scanner.nextLine()));  // Chong troi lenh

        customer.setRole(Role.CUSTOMER);

        customer.setName(scanner.nextLine());

        customer.setEmail(scanner.nextLine());
        if(employee.requestNewCustomer(customer)){
            System.out.println("Add new Customer Success");
        }
        else {
            System.out.println("Add new Customer Fail");
        }
    }

    @Override
    public int getAccountByID(int id) {
        System.out.println("Customer getAccountByID");
        return 0;
    }

    @Override
    public void checkBalance(){
        System.out.println("Customer check Balance");
    }

    public Customer(int id, double balance, Role role, String name, String email) {
        super(id, balance, role, name, email);
    }
    public Customer(){

    }

}
