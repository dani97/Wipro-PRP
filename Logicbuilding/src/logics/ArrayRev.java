package logics;

import java.util.Scanner;

public class ArrayRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n]; 
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		for(int i=0;i<n/2;i++){
			int t = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = t;
		}
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
		sc.close();
	}

}
