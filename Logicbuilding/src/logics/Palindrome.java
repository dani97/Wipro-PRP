package logics;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		sc.close();
		boolean flag =false;
		for(int i=0;i<a.length()/2;i++){
			if(a.charAt(i)!=a.charAt(a.length()-1-i)){
				System.out.println("Not palindrome");
				flag = true;
				break;
			}
		}
		if(!flag){
			System.out.println("Palindrome");
		}

	}

}
