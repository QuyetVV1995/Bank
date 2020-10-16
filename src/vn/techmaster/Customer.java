package vn.techmaster;

import java.util.Date;
import java.util.Scanner;

public class Customer extends Account {

    Employee employee = new Employee();

    public boolean withdrawal(int id, double value){
        boolean tmp = false;
        Customer customer = new Customer();
        for(int i = 0; i < DBAccount.dbCustomer.size(); i++){
            if(DBAccount.dbCustomer.get(i).getId() == id){
                customer = DBAccount.dbCustomer.get(i);
                if(customer.getBalance() < value){
                    System.out.println("Not Enough Money");
                }else{
                    if(employee.requestWithdrawal(customer)){
                        customer.setBalance(customer.getBalance() - value);
                        System.out.println("Update Balance after withdrawal: " + customer.getBalance());
                        tmp = true;
                    }else{
                        System.out.println("Admin not approval");
                    }
                }
            }
        }
        return tmp;
    }

    public boolean sendMoney(int id, double value){
        boolean tmp = false;
        Customer customer = new Customer();
        for(int i = 0; i < DBAccount.dbCustomer.size(); i++){
            if(DBAccount.dbCustomer.get(i).getId() == id){
                customer = DBAccount.dbCustomer.get(i);

                    if(employee.requestSendMoney(customer)){
                        customer.setBalance(customer.getBalance() + value);
                        System.out.println("Update Balance: " + customer.getBalance());
                        tmp = true;
                    } else{
                        System.out.println("Admin not approval");
                    }
            }
        }
        return tmp;
    }

    public void transfer(int form, int to, double value){
        if(withdrawal(form,value) && sendMoney(to, value)){
            System.out.println("Transfer success");
        } else {
            System.out.println("Transfer fail");
        }
    }

    @Override
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Input new Customer: ID, Balance, Name, Email");
        customer.setId(Integer.parseInt(scanner.nextLine()));       // Chong troi lenh

        customer.setBalance(Double.parseDouble(scanner.nextLine()));  // Chong troi lenh

        customer.setRole(Role.CUSTOMER);

        customer.setName(scanner.nextLine());

        customer.setEmail(scanner.nextLine());

        if(checkAccountExist(customer.getName())){
            System.out.println("Customer exist");
        }else{
            if(employee.requestNewCustomer(customer)){
                System.out.println("Add new Customer Success");
            }
            else {
                System.out.println("Add new Customer Fail");
            }
        }
    }

    @Override
    public boolean checkAccountExist(String name){
        boolean tmp = false;
        for (int i = 0; i < DBAccount.dbCustomer.size(); i++){
            // TODO: check again
            if(DBAccount.dbCustomer.get(i).getName() == name){
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
        for (int i = 0; i < DBAccount.dbCustomer.size(); i++){
            if(DBAccount.dbCustomer.get(i).getId() == id){
                System.out.println("ID: " + DBAccount.dbCustomer.get(i).getId());
                System.out.println("Name: " + DBAccount.dbCustomer.get(i).getName());
                System.out.println("Email: " + DBAccount.dbCustomer.get(i).getEmail());
                System.out.println("Role: " + DBAccount.dbCustomer.get(i).getRole());
                System.out.println("Balance: " + DBAccount.dbCustomer.get(i).getBalance());
            }
        }
    }

    @Override
    public double checkBalance(int id){
        double tmp = 0;
        for (int i = 0; i < DBAccount.dbCustomer.size(); i++){
            if(DBAccount.dbCustomer.get(i).getId() == id){
               tmp = DBAccount.dbCustomer.get(i).getBalance();
            }
        }
        return tmp;
    }

    public Customer(int id, double balance, Role role, String name, String email) {
        super(id, balance, role, name, email);
    }
    public Customer(){

    }
}
