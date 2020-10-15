package vn.techmaster;

import java.util.Scanner;

public class Admin implements IAdmin {
    Scanner scanner = new Scanner(System.in);
    private String approval;
    public boolean approvalNewAccount(){
        System.out.println(" Approval new Account: Yes/No?");
        approval = scanner.nextLine();
        System.out.println(approval);
        if(approval=="Yes"){
            return true;
        }else {
            return false;
        }
    }
}
