/*牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成
  16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？ 
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。


输出描述:
输出一行表示牛牛所能取得的最大的价值。

输入例子:
4 4
3332
3233
3332
2323

输出例子:
2*/ 
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
