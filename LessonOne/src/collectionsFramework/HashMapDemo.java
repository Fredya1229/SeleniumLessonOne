package collectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String,Integer> td = new HashMap<>();
		
		td.put("Fred", 12345);
		td.put("Alli", 543210);
		td.put("Axel", 2142);
		td.put("Derek", 9546);
		
		for(Map.Entry m: td.entrySet()){
			
			System.out.println(m.getKey() + "-" + m.getValue());
			
		}
		
	}

}
