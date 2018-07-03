package com.hk;

public class EnumToInt {
	
	
	public static void main(String[] args)
	{
		TestENUM theE = TestENUM.VAL_1;
		int intval = theE.ordinal();
		TestENUM converted = TestENUM.values()[1];
		
		System.out.println(theE);
		System.out.println(intval);
		System.out.println(converted);
	}

}
