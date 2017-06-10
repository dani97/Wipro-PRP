package logics;

import java.util.Scanner;

public class Substring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		StringBuilder maxString = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				int k=i;
				int l=j;
				if(s1.charAt(i)==s2.charAt(j)){
					StringBuilder sb = new StringBuilder();
					while(s1.charAt(k)==s2.charAt(l)){
						sb.append(s1.charAt(k));
						l++;
						k++;
						if(!(k<s1.length()&&l<s2.length())){
							break;
						}
					}
					if(sb.length()>maxString.length()){
						maxString = sb;
					}	
				}
			}
		}
		System.out.println(maxString.toString());

	}

}
