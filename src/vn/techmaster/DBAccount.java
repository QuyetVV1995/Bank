package vn.techmaster;

import java.util.ArrayList;

public class DBAccount {
    public static ArrayList<Customer> dbcustomers = new ArrayList<Customer>();

    static {
        dbcustomers.add(new Customer(1,10.0,Role.CUSTOMER,"abc","abc@gmail.com"));
        dbcustomers.add(new Customer(2,20.0,Role.CUSTOMER,"def","def@gmail.com"));
        dbcustomers.add(new Customer(3,30.0,Role.CUSTOMER,"ABC","ABC@gmail.com"));
        dbcustomers.add(new Customer(4,40.0,Role.CUSTOMER,"DEF","DEF@gmail.com"));
    }
}
