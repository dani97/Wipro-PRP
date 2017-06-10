package logics;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Frequecy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<Character,Integer> hm = new LinkedHashMap<Character,Integer>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(hm.containsKey(c)){
				hm.put(c, hm.get(c)+1);
			}
			else{
				hm.put(c, 1);
			}
		}
		Iterator<Entry<Character, Integer>> it = hm.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
	}

}
