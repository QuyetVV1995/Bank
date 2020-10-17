package vn.techmaster;

public interface IEmployee {
    boolean requestWithdrawal(Customer custome, double value);

    boolean requestSendMoney(Customer customer, double value);

    boolean requestNewCustomer(Customer customer);

    boolean requestBorrowMoney(Customer customer, double value);
}
