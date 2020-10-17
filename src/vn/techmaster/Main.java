package vn.techmaster;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Employee employee = new Employee();
        Admin admin = new Admin();
        // function common: createAccount, displayAccount, checkBalance, checkAccountExist,getListAccount

        // customer: withdrawal, sendMoney, transfer, borrowMoney

        //customer.createAccount();
        //customer.transfer(1,2,5);
        customer.borrowMoney(1,7);


        // admin
        //customer.getListAccount(Role.CUSTOMER);
        //.getListAccount(Role.EMPLOYEE);
    }
}
