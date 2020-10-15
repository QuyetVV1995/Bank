package vn.techmaster;

public class Main {

    public static void main(String[] args) {
        ICustomer iCustomer = new Customer();
	    Customer customer1 = new Customer(5,10d,Role.CUSTOMER,"abc","quyeta2ubqn@gmail.com");
	    iCustomer.createAccount(customer1);
    }
}
