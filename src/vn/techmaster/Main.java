package vn.techmaster;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Employee employee = new Employee();
        Admin admin = new Admin();
        //employee.createAccount();
        customer.transfer(1,2, 5);
        admin.getListAccount(Role.ADMIN);
    }
}
