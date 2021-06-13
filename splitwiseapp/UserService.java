package splitwiseapp;

import projectmanagementTrello.UserEnum;

import java.util.HashMap;
import java.util.Map;

import static splitwiseapp.UserIdConstants.*;

public class UserService extends IUserService<String>{

    public UserService() {
    }

    @Override
    Map<String, User<String>> createUserMapObject(){
        return new HashMap<>();
    }

    @Override
    public Map<String, User<String>> createUserMap() {
        userMap = createUserMapObject();
        addUserToMap(userMap, U1, UserEnum.JETHA);
        addUserToMap(userMap, U2, UserEnum.AYYAR);
        addUserToMap(userMap, U3, UserEnum.POPAT);
        addUserToMap(userMap, U4, UserEnum.GOLI);
        return userMap;
    }

    private void addUserToMap(Map<String, User<String>> userMap, String id, UserEnum name){
        try {
            User user = createUser(U1, UserEnum.JETHA);
        } catch (IllegalAccessException illegalAccessException) {
            System.out.println("A user with this id:"+id+ " already exists"+" "+ illegalAccessException.getMessage());
            System.out.println(illegalAccessException);
        }
        return;
    }

}
