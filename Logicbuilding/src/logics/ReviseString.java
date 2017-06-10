package logics;

import java.util.Scanner;

public class ReviseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str  = sc.nextLine();
		sc.close();
		str = str.replaceAll("[aeiou]", "z");
		System.out.println(str);

	}

}
