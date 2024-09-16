package ans;

import java.util.HashMap;

public class Q4 {

	public static HashMap<Integer, String> checkMedal(HashMap<Integer, Integer> a){
		
		HashMap<Integer, String> b = new HashMap<>();
		
		for(HashMap.Entry<Integer, Integer> i: a.entrySet()) {
			 int regNum = i.getKey();  
	         int marks = i.getValue();    

	         if (marks >= 90) {
	        	 b.put(regNum, "Gold");
	         } else if (marks >= 80 && marks < 90) {
	             b.put(regNum, "Silver");
	         } else if (marks >= 70 && marks < 80) {
	             b.put(regNum, "Bronze");
	         }
	         else {
	        	 b.put(regNum, "No Medal For You.");
	         }
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> stuDetails= new HashMap<>();
		
		stuDetails.put(1230, 92);
		stuDetails.put(3450, 82);
		stuDetails.put(5670, 72);
		stuDetails.put(7890, 62);
		
		HashMap<Integer, String> medalWinners = checkMedal(stuDetails);

        System.out.println(medalWinners);
		
		
	}

}
