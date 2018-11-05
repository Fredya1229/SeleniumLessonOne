package collectionsFramework;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		ArrayList<String> cities = new ArrayList<>();
		
		cities.add("London");
		cities.add("Quito");
		cities.add("Rio");
		cities.add("New York");
		cities.add("Miami");
		cities.add("Fort Lauderdale");
		cities.add("New York");
		
		for(String t: cities){
			
			System.out.println(t);
		}
	System.out.println(cities.get(3));
	System.out.println("index of Rio is  " + cities.indexOf("Rio"));
	System.out.println("Total items in the arraYLIST IS  " + cities.size());
	System.out.println("is  Quito present in the arraylits - " + cities.contains("Quitoo"));
	//Days obj1 = new Days();
	//obj1.day();
}
}
;
