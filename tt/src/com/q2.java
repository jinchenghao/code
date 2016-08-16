package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q2 {
	private static int minval = 0;
	 public static void main(String[] arg){
	        Scanner scan=new Scanner(System.in);
	        int n,m;
	        int[] minp = new int [2];
	        n = scan.nextInt();
	        m = scan.nextInt();
	        if(n<4||m<4) System.out.print(0);
	        String[] str =new String [n];
	        int[][] text = new int [n][m];
	        for(int i = 0; i < n ;i++)
	        	str[i] = scan.next();
	        for(int i = 0; i < n ;i++)
	        	for(int j = 0; j < m; j++){
	        		text[i][j] = Integer.valueOf(str[i].charAt(j))-48;
	        	}
	        
	        getMaxval( text,n , m ,minp);
	        solve(n,m,text,minp);
	        System.out.print(minval);
	 }

	private static void solve(int n, int m, int[][] text, int[] minp) {
		// TODO Auto-generated method stub
		int[][] temp = new int [n][m];
		temp = text;
		int minN = minp[0];
		int minM = minp[1];
		
		if(n==3||m==3) {/*System.out.print(minval);*/return;}
		
		if(minN>0 && n>3){
			text = mergetext(n,m,text,minN-1,minM,minp,1);
			solve( text.length-1, text[0].length,text,minp);
		}
		
		text = temp;
		
		if(minN<n && n>3){
			text = mergetext(n,m,text,minN,minM,minp,1);
			solve( text.length-1, text[0].length,text,minp);
		}
		
		text = temp;
		
		if(minM>0 && m>3){
			text = mergetext(n,m,text,minN,minM-1,minp,-1);
			solve( text.length, text[0].length-1,text,minp);
		}
		
		text = temp;
		
		if(minM<m && m>3){
			text = mergetext(n,m,text,minN,minM,minp,-1);
			solve( text.length, text[0].length-1,text,minp);
		}
			
	}

	private static int[][] mergetext(int n, int m, int[][] text, int mergen, int mergem,int[] minp,int flag) {
		int[][] temp = new int [n][m];
		
		if (flag == 1){
			for(int i = 0;i<n-1;i++){
				for(int j = 0;j<m;j++){
					if(i <mergen){
						temp[i][j] = text[i][j];
					}
					else if(i == mergen){
						temp[i][j] = text [i][j] + text[i+1][j];
					}
					else {
						temp[i][j] = text[i+1][j];
					}
				}
			}
		if(flag == -1){
			for(int j = 0;j<m-1;j++){
				for(int i = 0;i<n;i++){
					if(i <mergen){
						temp[i][j] = text[i][j];
					}
					else if(i == mergen){
						temp[i][j] = text [i][j] + text[i][j+1];
					}
					else {
						temp[i][j] = text[i][j+1];
					}
				}
			}
		}
		
		getMaxval(temp,n,m,minp);

		}
		return temp;
		// TODO Auto-generated method stub
		
	}

	private static void getMaxval(int[][] temp, int n, int m, int[] minp) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<n;i++){
			for(int j = 0;j<m;j++){
				if(min>temp[i][j]){
					min = temp[i][j];
					minp[0] = i;
					minp[1] = j;
				}
			}
		}
		
		if(min>minval) minval = min;
		
	}

}
