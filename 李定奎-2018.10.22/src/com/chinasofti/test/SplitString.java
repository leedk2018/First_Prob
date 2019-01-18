package com.chinasofti.test;

public class SplitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="name=zhangsan  age=18  classNo=090728";
		String[] arrStrings=s.split(" +");
		System.out.println(arrStrings.length);
		for(String a: arrStrings){
			System.out.print(a.substring(a.indexOf('=')+1)+" ");
		}
	}

}
