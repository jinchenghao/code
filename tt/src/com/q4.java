/*航天飞行器是一项复杂而又精密的仪器，飞行器的损耗主要集中在发射和降落的过程，科学家根据实验数据估计，如果在发射过程中，产生了 x 程度的损耗，
那么在降落的过程中就会产生 x2 程度的损耗，如果飞船的总损耗超过了它的耐久度，飞行器就会爆炸坠毁。问一艘耐久度为 h 的飞行器，假设在飞行过程中不产生损耗，那么为了保证其可以安全的到达目的地，只考虑整数解，至多发射过程中可以承受多少程度的损耗？ 
输入描述:
每个输入包含一个测试用例。每个测试用例包含一行一个整数 h （1 <= h <= 10^18）。


输出描述:
输出一行一个整数表示结果。

输入例子:
10

输出例子:
2*/
package com;

import java.util.Scanner;

public class q4 {

	public static void main(String[] argv) {
		Scanner sca = new Scanner(System.in);
		Long h = sca.nextLong();
		Long mid = (long) 0;
		Long left = (long) Math.sqrt(h)-1, rightLong = h;
		/*
		 * Long i = sca.nextLong(); System.out.println(i*i);
		 */
		do {
			mid = (long) (left + rightLong) / 2;
			if(mid > (long) Math.sqrt(Math.pow(10, 18))){
				rightLong = mid;
				continue;
			}
			if ((mid + mid * mid <= h) && (mid + 1 + Math.pow(mid + 1, 2) > h)) {
				System.out.print(mid);
				break;
			} else if (mid + mid * mid < h) {
				left = mid;
			} else if (mid + mid * mid > h) {
				rightLong = mid;
			}
			// System.out.println("*");
		} while (left < rightLong);
		/*
		 * for(i = (long) Math.sqrt(h/2); i<Math.sqrt(h); i++){ if((i + i*i <=
		 * h) && (i+1+Math.pow(i+1, 2) > h)){ break; } } System.out.print(i);
		 */
	}

}
