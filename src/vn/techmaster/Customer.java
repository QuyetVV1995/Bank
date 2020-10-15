package vn.techmaster;

public class Customer extends Account implements ICustomer {
    private String name;
    private String email;

    IEmployee employee = new Employee();

    public Customer() {
        super();
    }

    public void createAccount(Customer customer){
        if(!employee.validationAccountExist(customer)){
            if(employee.confirmInfoAccount(customer)){
                System.out.println("Account da duoc tao thanh cong");
            } else {
                System.out.println("Admin not approval");
            }

        } else {
            System.out.println("Khong tao duoc account");
        }
    }

    @Override
    public double checkBalance(int id) {
        double balanceStatus = 0d;
        // TODO: check Account id in Database
        for(int i = 0; i < DBAccount.dbcustomers.size(); i++){
           if(DBAccount.dbcustomers.get(i).getId() == id){
               balanceStatus = DBAccount.dbcustomers.get(i).getBalance();
           }
        }
       return balanceStatus;
    }

    @Override
    public void withdrawal(int id, double value) {
        for(int i = 0; i < DBAccount.dbcustomers.size(); i++){
            if(DBAccount.dbcustomers.get(i).getId() == id){
                if(value > checkBalance(id)){
                    System.out.println("Not Enough Money");
                }
                else{
                    DBAccount.dbcustomers.get(i).setBalance(DBAccount.dbcustomers.get(i).getBalance() - value);
                }
            }
        }
    }

    @Override
    public void sendMoney(int id, double value) {
        for(int i = 0; i < DBAccount.dbcustomers.size(); i++){
            if(DBAccount.dbcustomers.get(i).getId() == id){

                DBAccount.dbcustomers.get(i).setBalance(DBAccount.dbcustomers.get(i).getBalance() + value);
            }
        }
    }


    public Customer(int id, double balance, Role role, String name, String email) {
        super(id, balance, role);
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
