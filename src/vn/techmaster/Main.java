package vn.techmaster;

public class Main {

    public static void main(String[] args) {
        ICustomer iCustomer = new Customer();
        IAdmin iAdmin = new Admin();
	    Customer customer1 = new Customer(5,10d,Role.CUSTOMER,"QuyetVV","quyeta2ubqn@gmail.com");
	    iCustomer.createAccount(customer1);
	    iCustomer.checkBalance(1);
	    iCustomer.withdrawal(1,3);
	    iCustomer.sendMoney(2,19);
        iAdmin.getListAccount();

    }
}
