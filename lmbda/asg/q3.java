package asg;

import java.util.function.*;

public class q3 {
	public static void main(String[] args) {

		String validUname = "admin";
        String validPass = "123";

        BiPredicate<String, String> auth = (username, password) -> username.equals(validUname) && password.equals(validPass);

        String inpUname = "admin";
        String inpPass = "123";

        boolean isAuth = auth.test(inpUname, inpPass);
        System.out.println("Authentication result: " + isAuth);  
    }
}
