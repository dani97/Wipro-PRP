package logics;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int sum =0;
		while(n>0){
			sum += n%10;
			n/=10;
		}
		sc.close();
		System.out.println(sum);
	}

}
