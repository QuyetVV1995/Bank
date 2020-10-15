package vn.techmaster;

public class Employee implements IEmployee {
    Admin admin = new Admin();

    public boolean validationAccountExist(Customer customer) {
        boolean exits = false;
        for (int i = 0; i < DBAccount.dbcustomers.size(); i++) {
            // TODO: check exist with Database
            if(DBAccount.dbcustomers.equals(customer.getName())) {
                System.out.println("account da ton tai");
                exits = true;
            } else {
                System.out.println("Account chua ton tai");
                exits = false;
            }
            break;
        }
        return exits;
    }



    public void confirmInfoAccount(Customer customer){
        System.out.println("Xac nhan lai thong tin khach hang");
        System.out.println("ID: " + customer.getId());
        System.out.println("Balance: " +customer.getBalance());
        System.out.println("Name: " +customer.getName());
        System.out.println("Email: " + customer.getEmail());
        admin.approvalNewAccount();
    }
}
