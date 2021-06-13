package splitwiseapp;

import projectmanagementTrello.UserEnum;

import java.util.Map;

public class User<T> {
    private T id;
    private UserEnum name;
    private Map<T, Double> owesTo;
    private double balance;

    public User(){}
    public User(T id, UserEnum name, Map<T, Double> owesTo, Double balance) {
        this.id = id;
        this.name = name;
        this.owesTo = owesTo;
        this.balance=balance;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public UserEnum getName() {
        return name;
    }

    public void setName(UserEnum name) {
        this.name = name;
    }

    public Map<T, Double> getOwesTo() {
        return owesTo;
    }

    public void setWesTo(Map<T, Double> wesTo) {
        this.owesTo = wesTo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", owesTo=" + owesTo +
                ", balance=" + balance +
                '}';
    }
}
