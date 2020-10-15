package vn.techmaster;

public interface ICustomer {
    public void createAccount(Customer customer);
    public double checkBalance(int id);
    void withdrawal(int id, double value);
    void sendMoney(int id, double value);

}
