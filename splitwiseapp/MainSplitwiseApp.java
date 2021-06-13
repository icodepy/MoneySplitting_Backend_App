package splitwiseapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static splitwiseapp.SpliwiseConstants.*;

public class MainSplitwiseApp {

    private static IUserService<Long> userService;

    public static void main(String... args) throws IOException {

        UserFactory factory = new UserFactory();
        userService = factory.createUser(UserType.USER);
        Map<String, User> userMap = userService.createUserMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String firstCommand = input[0];
        switch (firstCommand) {
            case EXPENSE:
                String userId = input[1];
                User user = userMap.get(userId);
                Double amtToBeDivided = Double.parseDouble(input[2]);
                Integer countMembers = Integer.parseInt(input[3]);
                Integer lastMemberIndex = countMembers + 3;
                String command = input[input.length - 1];
                try {
                    Double amtPerHead = amtToBeDivided / countMembers;
                    Integer lmi = lastMemberIndex;
                    for (int i = 4; i <= countMembers + 3; i++) {
                        String id = input[i];
                        User owingUser = userMap.get(id);
                        Map<String, Double> owesTo = owingUser.getOwesTo();
                        Double lastAmtOwed = owesTo.get(userId); // last owedAmt + currentOwedAmt
                        switch (command) {
                            case EQUAL:
                                owesTo.put(userId, amtPerHead + lastAmtOwed);
                                break;
                            case EXACT:
                                Double currentOwedAmt = Double.parseDouble(input[lmi++]);
                                owesTo.put(userId, currentOwedAmt + lastAmtOwed);
                                break;
                            case PERCENT:
                                currentOwedAmt = ((amtToBeDivided * 1.0000000d) / (100.0000000d)) * Double.parseDouble(input[lmi++]);
                                owesTo.put(userId, currentOwedAmt);
                                break;
                        }
                    }
                } catch (ArithmeticException aexc) {
                    System.out.println("EXCEPTION:: Divide by zero:" + aexc);
                    return;
                }catch(Exception exc){
                    System.out.println("EXCEPTION:: "+exc);
                }
                break;
            case SHOW:
                Integer l = input.length;
                if (l == 1) {
                    for (User tempUser : userMap.values()) {
                        Map<String, Double> owesTo = tempUser.getOwesTo();
                        for (Object tempId : owesTo.keySet()) {
                            String id = (String) tempId;
                            String name = String.valueOf(userMap.get(id).getName());
                            System.out.println(tempUser.getName() + " owes " + name + " " + owesTo.get(id));
                        }
                    }
                } else {
                    userId = input[1];
                    Map<String, Double> owesTo = userMap.get(userId).getOwesTo();
                    for (Object tempId : owesTo.keySet()) {
                        String id = (String) tempId;
                        String name = String.valueOf(userMap.get(id).getName());
                        System.out.println(userMap.get(userId).getName() + " owes " + name + " " + owesTo.get(id));
                    }
                }
                break;

        }

    }
}
