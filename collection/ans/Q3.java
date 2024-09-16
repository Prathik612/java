package ans;

import java.util.HashMap;

public class Q3 {
	public static HashMap<Integer, Integer> sqr(int[] a) {
		HashMap<Integer, Integer> hMap = new HashMap<>();
		
		for(int i: a) {	
				hMap.put(i, i*i);
		}
		
		return hMap;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		HashMap<Integer, Integer> result = sqr(arr);
		
		System.out.println(result);
	}
}
