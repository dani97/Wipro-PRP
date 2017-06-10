package logics;

import java.util.Scanner;

public class RevPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 =sc.nextLine();
		
		StringBuilder sb = new StringBuilder(s1);
		for(int i=0;i<s2.length();i++){
			sb.append(s2.charAt(s2.length()-1-i));
		}
		System.out.println(sb);
		sc.close();
	}

}
