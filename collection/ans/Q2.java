package ans;

import java.util.*;

public class Q2 {
	
	public static HashMap<Character, Integer> charCount(char[] ch) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		
		for(char c: ch) {
			if(hMap.containsKey(c)) {
				hMap.put(c, hMap.get(c)+1);
			}
			else {
				hMap.put(c, 1);
			}
		}
		
		return hMap;
	}

	public static void main(String[] args) {
		char[] chArr = {'a', 'b', 'a', 'c', 'b', 'a', 'd', 'c', 'e'};

		HashMap<Character, Integer> result = charCount(chArr);
		
		System.out.println(result);
	}

}
