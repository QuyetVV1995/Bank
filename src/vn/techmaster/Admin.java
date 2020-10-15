package vn.techmaster;

import java.util.Scanner;

public class Admin implements IAdmin {
    Scanner scanner = new Scanner(System.in);
    private int approval;
    public boolean approvalNewAccount(){
        System.out.println(" Approval new Account: 1-Yes/ 2-No?");
        approval = scanner.nextInt();
        System.out.println(approval);

        if(approval==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void getListAccount() {
        for(int i = 0; i < DBAccount.dbcustomers.size(); i++){
            System.out.print(DBAccount.dbcustomers.get(i).getId() + " ");
            System.out.print(DBAccount.dbcustomers.get(i).getEmail()+ " ");
            System.out.print(DBAccount.dbcustomers.get(i).getName()+ " ");
            System.out.print(DBAccount.dbcustomers.get(i).getBalance()+ " ");
            System.out.print(DBAccount.dbcustomers.get(i).getRole()+ " ");
            System.out.println();
        }
    }
}
