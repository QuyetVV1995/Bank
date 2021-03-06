package vn.techmaster;

import java.util.Scanner;

public class Employee extends Account implements IEmployee {
    private double salary;
    IAdmin admin = new Admin();
    @Override
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Input new Employee: ID, Balance, Name, Email, Salary");
        employee.setId(Integer.parseInt(scanner.nextLine()));       // Chong troi lenh
        employee.setBalance(Double.parseDouble(scanner.nextLine()));  // Chong troi lenh
        employee.setRole(Role.EMPLOYEE);
        employee.setName(scanner.nextLine());
        employee.setEmail(scanner.nextLine());
        employee.setSalary(Double.parseDouble(scanner.nextLine()));

        if(checkAccountExist(employee.getName())){
            System.out.println("Employee exist");
        }else{
            if(admin.approvalNewEmployee(employee)){
                System.out.println("Add new Employee: Success");
            }else
            {
                System.out.println("Add new Employee: Fail");
            }
        }
    }

    @Override
    public boolean checkAccountExist(String name){
        boolean tmp = false;
        for (int i = 0; i < DBAccount.dbEmployee.size(); i++){
            // TODO: check again
            if(DBAccount.dbEmployee.get(i).getName() == name){
                tmp = true;
            }
            else{
                tmp = false;
            }
        }
        return tmp;
    }

    @Override
    public void displayInfoAccount(int id) {
        for (int i = 0; i < DBAccount.dbEmployee.size(); i++){
            if(DBAccount.dbEmployee.get(i).getId() == id){
                System.out.println("ID: " + DBAccount.dbEmployee.get(i).getId());
                System.out.println("Name: " + DBAccount.dbEmployee.get(i).getName());
                System.out.println("Email: " + DBAccount.dbEmployee.get(i).getEmail());
                System.out.println("Role: " + DBAccount.dbEmployee.get(i).getRole());
                System.out.println("Balance: " + DBAccount.dbEmployee.get(i).getBalance());
                System.out.println("Salary: " + DBAccount.dbEmployee.get(i).getSalary());
            }
        }
    }

    @Override
    public double checkBalance(int id){
        double tmp = 0;
        for (int i = 0; i < DBAccount.dbEmployee.size(); i++){
            if(DBAccount.dbEmployee.get(i).getId() == id){
                tmp = DBAccount.dbEmployee.get(i).getBalance();
            }
        }
        return tmp;
    }

    public boolean requestNewCustomer(Customer customer){
        System.out.println("ID: " + customer.getId());
        System.out.println("Balance: " + customer.getBalance());
        System.out.println("Role: " + customer.getRole());
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Borrow Money: " + customer.getBorrowMoney());
        System.out.println("Period: " + customer.getPeriod());
        System.out.println("InterestRate: " + customer.getInterestRate());

        if( admin.approvalNewCustomer(customer))
        {
            System.out.println("Request is approval");
            return true;
        } else{
            System.out.println("Not Approval");
            return false;
        }
    }

    @Override
    public boolean requestBorrowMoney(Customer customer, double value) {
        if (admin.approvalBorrowMoney(customer, value)) {
            return true;
        }else
        {
            System.out.println("Request Borrow Money is not approval");
            return false;
        }
    }

    public boolean requestWithdrawal(Customer customer, double value){
        if(admin.approvalWithdrawal(customer, value)){
            System.out.println("Request Withdrawal is approval");
            return true;
        } else{
            System.out.println("Request Withdrawal is Not Approval");
            return false;
        }
    }

    public boolean requestSendMoney(Customer customer, double value) {
        if(admin.approvalSendMoney(customer,value)){
            System.out.println("Request is approval");
            return true;
        } else{
            System.out.println("Not Approval");
            return false;
        }
    }

    @Override
    public void getListAccount(Role role){
        if(role == Role.CUSTOMER){
            System.out.println("ID Name Email Balance BorrowMoney Period InterestRate");
            for(int i = 0; i < DBAccount.dbCustomer.size(); i++){
                System.out.print(DBAccount.dbCustomer.get(i).getId() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getName() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getEmail() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getBalance() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getBorrowMoney() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getPeriod() + "  ");
                System.out.print(DBAccount.dbCustomer.get(i).getInterestRate() + "  ");
                System.out.println();
            }
        }else if (role == Role.EMPLOYEE){
            System.out.println("Access denied");
        } else {
            System.out.println("Access denied");
        }

    }

    public Employee(int id, double balance, Role role, String name, String email, double salary) {
        super(id, balance, role, name, email);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Employee() {

    }


}
