package com;

import java.util.Scanner;

public class q3 {
	
	public static void main(String argv[]){
		Scanner scn = new Scanner(System.in);
		
		int n;
		int sum = 0,avg = 0;
		int postive = 0, negtive = 0;
		boolean b = true;
		n = scn.nextInt();
		int[] cow = new int [n];
		for(int i = 0;i < n;i++){
			cow[i] = scn.nextInt();
			sum +=cow[i];
		}
		
		avg = sum/n;
		
		for(int i = 0;i < n;i++){
			if((cow[i] - avg) > 0) postive += (cow[i]-avg);
			if((cow[i] - avg) < 0) negtive += (cow[i]-avg);
			if((cow[i] - avg)%2 != 0) b = false;
		}
		
		/*((postive + negtive) == 0)?return postive/2 : return -1;*/
		if((postive + negtive) == 0 && postive%2 == 0 && b) System.out.print(postive/2);
		else System.out.print(-1);
		
	}

}
