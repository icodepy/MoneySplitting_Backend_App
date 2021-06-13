package splitwiseapp;

import projectmanagementTrello.UserEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class IUserService<T> {
    T id;
    public <T> User<T> createUser(T id, UserEnum name){
        Map<T, Double> owesTo = new HashMap<>();
        User<T> user = new User(id, name, owesTo, 0.0d);
        return user;
    }

    abstract <T> Map<T, User> createUserMap();

}
