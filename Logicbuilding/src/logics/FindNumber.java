package logics;

import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int difference = sc.nextInt();
		int x = (sum+difference)/2;
		int y = (sum-difference)/2;
		int result = x*10+y;
		System.out.println(result);
		sc.close();

	}

}
