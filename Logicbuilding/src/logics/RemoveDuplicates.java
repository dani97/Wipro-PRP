package logics;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<Character> ts = new LinkedHashSet<Character>();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		for(int i=0;i<s.length();i++){
			ts.add(s.charAt(i));
		}
		Iterator<Character> i =ts.iterator();
		while(i.hasNext())
		{
			System.out.print(i.next());
		}

	}

}
