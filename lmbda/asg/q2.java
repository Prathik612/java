package asg;

import java.util.function.*;


public class q2 {

	public static void main(String[] args) {
		Function<String, String> addSpaces = str -> String.join(" ", str.split(""));

        String input = "JHASVCJYASCVJASY";
        String result = addSpaces.apply(input);
        
        System.out.println("Formatted String: " + result);

	}

}
