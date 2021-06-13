package splitwiseapp;

public class UserFactory {

     IUserService createUser(UserType userType){
        switch(userType){
            case USER:
                return new UserService();
        }
        return null;
    }
}
