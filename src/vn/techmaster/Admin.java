package vn.techmaster;

import java.util.Scanner;

public class Admin extends Account implements IAdmin  {
    private double salary;
    private double bonus;
    Scanner scanner = new Scanner(System.in);


    @Override
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.println("Input new ADMIN: ID, Balance, Name, Email, Salary, Bonus");
        admin.setId(Integer.parseInt(scanner.nextLine()));
        admin.setBalance(Double.parseDouble(scanner.nextLine()));
        admin.setRole(Role.EMPLOYEE);
        admin.setName(scanner.nextLine());
        admin.setEmail(scanner.nextLine());
        admin.setSalary(Double.parseDouble(scanner.nextLine()));
        admin.setBonus(Double.parseDouble(scanner.nextLine()));
        if(checkAccountExist(admin.getName())){
            System.out.println("Admin exist");
        }else {
            DBAccount.dbAdmin.add(admin);
        }
    }

    @Override
    public boolean checkAccountExist(String name){
        boolean tmp = false;
        for (int i = 0; i < DBAccount.dbAdmin.size(); i++){
            // TODO: check again
            if(DBAccount.dbAdmin.get(i).getName() == name){
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
        for (int i = 0; i < DBAccount.dbAdmin.size(); i++){
            if(DBAccount.dbAdmin.get(i).getId() == id){
                System.out.println("ID: " + DBAccount.dbAdmin.get(i).getId());
                System.out.println("Name: " + DBAccount.dbAdmin.get(i).getName());
                System.out.println("Email: " + DBAccount.dbAdmin.get(i).getEmail());
                System.out.println("Role: " + DBAccount.dbAdmin.get(i).getRole());
                System.out.println("Balance: " + DBAccount.dbAdmin.get(i).getBalance());
                System.out.println("Salary: " + DBAccount.dbAdmin.get(i).getSalary());
                System.out.println("Bonus: " + DBAccount.dbAdmin.get(i).getBonus());
            }
        }
    }

    @Override
    public double checkBalance(int id){
        double tmp = 0;
        for (int i = 0; i < DBAccount.dbAdmin.size(); i++){
            if(DBAccount.dbAdmin.get(i).getId() == id){
                tmp = DBAccount.dbAdmin.get(i).getBalance();
            }
        }
        return tmp;
    }

    public boolean approvalNewCustomer(Customer customer){
        System.out.println("Approval new Customer: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            DBAccount.dbCustomer.add(customer);
            return true;
        } else{
            return false;
        }
    }

    public boolean approvalNewEmployee(Employee employee){
        System.out.println("Approval new Employee: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            DBAccount.dbEmployee.add(employee);
            return true;
        } else{
            return false;
        }
    }

    public boolean approvalWithdrawal(Customer customer, double value) {
        System.out.println("Approval withdrawal: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            customer.setBalance(customer.getBalance() - value);
            System.out.println("Update Balance after withdrawal: " + customer.getBalance());
            return true;
        } else{
            return false;
        }
    }

    public boolean approvalSendMoney(Customer customer, double value) {
        System.out.println("Approval sendMoney: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            customer.setBalance(customer.getBalance() + value);
            System.out.println("Update after add Money Balance: " + customer.getBalance());
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean approvalBorrowMoney(Customer customer, double value) {
        System.out.println("Approval Borrow Money: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            customer.setBalance(customer.getBalance() + value );
            customer.setBorrowMoney(value);
            System.out.println("Input period:");
            customer.setPeriod(scanner.nextDouble());

            System.out.println("Input InterestRate:");
            customer.setInterestRate(scanner.nextDouble());
            return true;
        } else{
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
            for(int i = 0; i < DBAccount.dbEmployee.size(); i++){
                System.out.print(DBAccount.dbEmployee.get(i).getId() + "  ");
                System.out.print(DBAccount.dbEmployee.get(i).getName() + "  ");
                System.out.print(DBAccount.dbEmployee.get(i).getEmail() + "  ");
                System.out.print(DBAccount.dbEmployee.get(i).getBalance() + "  ");
                System.out.println();
            }
        } else {
            for(int i = 0; i < DBAccount.dbAdmin.size(); i++){
                System.out.print(DBAccount.dbAdmin.get(i).getId() + "  ");
                System.out.print(DBAccount.dbAdmin.get(i).getName() + "  ");
                System.out.print(DBAccount.dbAdmin.get(i).getEmail() + "  ");
                System.out.print(DBAccount.dbAdmin.get(i).getBalance() + "  ");
                System.out.println();
            }
        }

    }

    public Admin(int id, double balance, Role role, String name, String email, double salary, double bonus) {
        super(id, balance, role, name, email);
        setBonus(bonus);
        setSalary(salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Admin() {

    }

}
