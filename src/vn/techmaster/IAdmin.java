package vn.techmaster;

public interface IAdmin {
    boolean approvalNewEmployee(Employee employee);

    boolean approvalNewCustomer(Customer customer);

    boolean approvalWithdrawal(Customer customer, double value);

    boolean approvalSendMoney(Customer customer, double value);
}
