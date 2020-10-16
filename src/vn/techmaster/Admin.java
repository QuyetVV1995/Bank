package vn.techmaster;

import java.util.Scanner;

public class Admin extends Account  {
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
    public void searchAccountById(int id) {
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

    public boolean approvalWithdrawal() {
        System.out.println("Approval withdrawal: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
            return true;
        } else{
            return false;
        }
    }
    public boolean approvalSendMoney() {
        System.out.println("Approval sendMoney: 1-Yes/2-No");
        int approval =  scanner.nextInt();
        if(approval == 1){
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
