package ans;

import java.util.*;

public class Q1 {
	
	public static List<Integer> sortedVals(HashMap<String, Integer> map){
		List<Integer> vals = new ArrayList<>(map.values());
		
		Collections.sort(vals);
		
		return vals;
	}

	public static void main(String[] args) {
		HashMap<String, Integer> hMap = new HashMap<>();
		
		hMap.put("Apple", 2);
		hMap.put("Chair", 1);
		hMap.put("Cat", 9);
		hMap.put("Door", 34);
		
		List<Integer> sVals = sortedVals(hMap);
		
		System.out.println(sVals);
	}

}
