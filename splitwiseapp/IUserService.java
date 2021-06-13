package splitwiseapp;

import projectmanagementTrello.UserEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class IUserService<T> {
    T id;
    Map<T, User<T>> userMap;
    public <T> User<T> createUser(T id, UserEnum name) throws IllegalAccessException{
        if(userMap.containsKey(id)) throw new IllegalAccessException("User with this id already Exists");
        Map<T, Double> owesTo = new HashMap<>();
        User<T> user = new User(id, name, owesTo, 0.0d);
        return user;
    }

    abstract <T> Map<T, User> createUserMap();
    abstract <T> Map<T, User> createUserMapObject();
}
