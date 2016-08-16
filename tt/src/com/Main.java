package com;  

import java.util.Scanner;


	 public class Main {
	     public static void main(String[] args) {
	    	 Scanner in = new Scanner(System.in);
	         int num;
	         num = in.nextInt();
	         long[] stu = new long [num];
	         for(int i = 0 ; i<num ; i++)
	        	 stu[i] = in.nextInt();
	         int disk , disd ;
	         disk = in.nextInt();
	         disd = in.nextInt();
	         getanswer(stu , disk , disd);
	    }

		private static void getanswer(long[] stu, int disk, int disd) {
			// TODO Auto-generated method stub
			long[][] maxnum = new long [stu.length][disk+1];
			long[][] minnum = new long [stu.length][disk+1];
			long result = 1;
			//int max = 0,min = 0;
			for(int i = 0 ; i<stu.length ; i++){
				maxnum[i][0] = 1;
				minnum[i][0] = 1;
			}
			for(int i = 0 ; i<stu.length ; i++){
				maxnum[i][1] = stu[i];
				minnum[i][1] = stu[i];
				if(stu[i] > result){result = stu[i];}
				
			}
			for(int k = 2 ; k<disk+1 ; k++)
				for(int i = 0 ; i<stu.length ; i++)
				{
					long tempMax , tempMin, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
					if(i < k-1)
					{
						maxnum[i][k] = 1;
						minnum[i][k] = 1;
					}
					
					else{
						for(int j = k-2 ; j<i ;j++)
						{
							if(j >= i-disd){
								 tempMax = maxnum[j][k-1]*stu[i];
								 tempMin = minnum[j][k-1]*stu[i];
								max = Math.max(max, Math.max(tempMax, tempMin));
								min = Math.min(min, Math.min(tempMax, tempMin));
								
							}
						}
						maxnum[i][k] = max;
						minnum[i][k] = min;
						if(max > result) result = max;
					}
					
					
				}
			System.out.print(result);
		}
 }