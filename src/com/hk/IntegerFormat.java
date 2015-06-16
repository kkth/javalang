package com.hk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntegerFormat {

	public static void main(String[] args)
	{
		
		int x =0;
		String str = String.format("%06d",x);
		System.out.println(str);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Date d =new Date();
		  String dd =format.format(d);
		  System.out.println(dd);
	}
}
