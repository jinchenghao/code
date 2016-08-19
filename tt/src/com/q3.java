/*n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个
苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。 
输入描述:
每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。


输出描述:
输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。

输入例子:
4
7 15 9 5

输出例子:
3*/
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
