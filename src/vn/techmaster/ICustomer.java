package vn.techmaster;

public interface ICustomer {
    void createAccount(Customer customer);
    double checkBalance(int id);
    void withdrawal(int id, double value);
    void sendMoney(int id, double value);
}
