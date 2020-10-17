package vn.techmaster;

public interface IEmployee {
    boolean requestWithdrawal(Customer customer);

    boolean requestSendMoney(Customer customer);

    boolean requestNewCustomer(Customer customer);
}
