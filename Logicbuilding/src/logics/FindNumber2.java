package logics;

import java.util.Scanner;

public class FindNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int product = sc.nextInt();
		int quotient = sc.nextInt();
		double x = Math.sqrt((double)(product*quotient));
		double y = Math.sqrt(product/quotient);
		System.out.println(x+" "+y);
		System.out.println((int)x+y);
		sc.close();
	}

}
