package vn.techmaster;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Employee employee = new Employee();
        Admin admin = new Admin();
//       customer.createAccount();
//        customer.checkAccountExist("abc");
//        customer.withdrawal(1,5);
//        customer.sendMoney(1,3);
//        customer.searchAccountById(1);
//       admin.getListAccount(Role.CUSTOMER);
//        customer.transfer(1,2, 5);
//        admin.getListAccount(Role.ADMIN);
        customer.borrowMoney(1,7);
    }
}
