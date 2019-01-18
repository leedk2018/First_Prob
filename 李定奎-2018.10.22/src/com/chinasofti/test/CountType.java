package com.chinasofti.test;

import java.util.Scanner;

public class CountType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String string = scn.nextLine();
		int u=0,l=0,n=0,s=0;
		for (int j = 0; j < string.length(); j++) {
			if (string.charAt(j)>='A'&&string.charAt(j)<='Z') {
				u++;
			} else if(string.charAt(j)>='a'&&string.charAt(j)<='z'){
				l++;
			}else if (string.charAt(j)>='0'&&string.charAt(j)<='9') {
				n++;
			}else if (string.charAt(j)==' ') {
				s++;
			}
		}
		System.out.println("以上字符串:");
		System.out.println("大写字母:"+u+" "+"小写字母:"+l+" "+"数字:"+n+" "+"空格:"+s);
		scn.close();
	}

}
