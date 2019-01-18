package com.chinasofti.test;

public class StringAndSpace {
	public  String toHashcode(String string) {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "113 ere qqq yyui";
		String[] arrStrings = s.split(" +");
//		for (String a : arrStrings) {
//			System.out.println(a);
//		}
		StringAndSpace adAndSpace=new StringAndSpace();
		String bString="b";
		String cString="a"+"b";
		String eString=new String("asd");
		System.out.println(adAndSpace.toHashcode("st".replace('t', 'T'))+" "+ adAndSpace.toHashcode("st".replace('t', 'T')));
		System.out.println("st".replace('t', 't')=="st".replace('t', 't'));
	}
}
