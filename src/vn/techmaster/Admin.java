package vn.techmaster;

import java.util.Scanner;

public class Admin extends Account implements IAdmin {
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
        DBAccount.dbAdmin.add(admin);
    }

    @Override
    public int getAccountByID(int id) {
        System.out.println("Admin getAccountByID");
        return 0;
    }

    @Override
    public void checkBalance(){
        System.out.println("Admin check Balance");
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
