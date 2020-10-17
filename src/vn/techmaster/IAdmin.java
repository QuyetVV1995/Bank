package vn.techmaster;

public interface IAdmin {
    boolean approvalNewEmployee(Employee employee);

    boolean approvalNewCustomer(Customer customer);

    boolean approvalWithdrawal();

    boolean approvalSendMoney();
}
