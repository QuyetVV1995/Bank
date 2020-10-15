package vn.techmaster;

import java.util.ArrayList;

public class Customer extends Account implements ICustomer {
    private String name;
    private String email;

    Employee employee = new Employee();

    public Customer() {
        super();
    }

    public void createAccount(Customer customer){
        if(!employee.validationAccountExist(customer)){
            employee.confirmInfoAccount(customer);
            System.out.println("Account da duoc tao thanh cong");
        } else {
            System.out.println("khong the tao duoc Account");
        }
    }

    public Customer(int id, double balance, Role role, String name, String email) {
        super(id, balance, role);
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
