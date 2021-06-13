package splitwiseapp;

import projectmanagementTrello.UserEnum;

import java.util.HashMap;
import java.util.Map;

public class UserService extends IUserService<String>{

    public UserService() {
    }

    @Override
    public Map<String, User<String>> createUserMap() {
        Map<String, User<String>> userMap = new HashMap<>();
        userMap.put("u1", createUser("u1", UserEnum.JETHA));
        userMap.put("u2", createUser("u2", UserEnum.AYYAR));
        userMap.put("u3", createUser("u3", UserEnum.POPAT));
        userMap.put("u4", createUser("u3", UserEnum.GOLI));
        return userMap;
    }

}
