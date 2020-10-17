package vn.techmaster;

public class Account {
    private int id;
    private double balance;
    private Role role;
    private String name;
    private String email;

    public void createAccount(){

    }

    public void displayInfoAccount(int id) {

    }

    public double checkBalance(int id){
        return 0;
    }

    public boolean checkAccountExist(String name){
        return true;
    }

    public void getListAccount(Role role){
        System.out.println("Access denice");
    }

    public Account(int id, double balance, Role role, String name, String email) {
        setId(id);
        setBalance(balance);
        setRole(role);
        setEmail(email);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Account() {

    }




}
