package collectionsFramework;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> cities =  new TreeSet<>();
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
		
		
//		Iterator<String> itr = cities.iterator();
//		while(itr.hasNext()){
//			
//			System.out.println(itr.next());
//		}
		
		
	System.out.println();	
		
	//System.out.println(cities.get(3));
	//System.out.println("index of Rio is  " + cities.indexOf("Rio"));
	System.out.println("Total items in the LinkList IS  " + cities.size());
	System.out.println("is  Quito present in the LinkList - " + cities.contains("Quitoo"));
		

	}

}
