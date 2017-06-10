package logics;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
	public static void main(String [] args){
		int n;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		sc.close();
		System.out.println("factorial of"+n+"= "+Fact(n));
	}

	private static  BigInteger Fact(int n) {
		// TODO Auto-generated method stub
		BigInteger fact = new BigInteger("1");
		for(int i=1;i<=n;i++){
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}
}
