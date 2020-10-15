package vn.techmaster;

public abstract class Account {
    private int id;
    private double balance;
    private Role role;

    public Account(int id, double balance, Role role) {
        setId(id);
        setBalance(balance);
        setRole(role);
    }

    public Account() {

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
}
