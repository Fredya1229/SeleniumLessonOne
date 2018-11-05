package collectionsFramework;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String> cities2 = new HashSet<>();
		
		//to add hasset to arraylist
		ArrayList<String> cities = new ArrayList<>();
		
		cities2.add("London");
		cities2.add("Quito");
		cities2.add("Rio");
		cities2.add("New York");
		cities2.add("Miami");
		cities2.add("Fort Lauderdale");
		cities2.add("New York");
		
		cities.addAll(cities2);
		
		for(String t: cities2){
			
			System.out.println(t);
		}
		
		System.out.println();
		
	System.out.println(cities.get(3));
	System.out.println("index of Rio is  " + cities.indexOf("Rio"));
	System.out.println("Total items in the HashSet IS  " + cities2.size());
	System.out.println("is  Quito present in the HashSet - " + cities2.contains("New York"));
		
	}

}
