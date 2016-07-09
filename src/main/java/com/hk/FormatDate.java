package com.hk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMM");
		
		long curTime = System.currentTimeMillis();
		long yesterdayTime = curTime - 24*3600*1000;
		Date today =new Date(curTime);
		Date yesterday = new Date(yesterdayTime);
		
		String day =format1.format(today);
		String month = format2.format(today);
		
		
		System.out.println(day);
		System.out.println(month);
		
		String yday =format1.format(yesterday);
		String ymonth = format2.format(yesterday);
		
		System.out.println("------");
		System.out.println(yday);
		System.out.println(ymonth);
		
		
		
		////Calendar
		
		System.out.println("------");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(curTime);
		c.add(Calendar.MONTH, -1);
		String lastmonth = format2.format(c.getTime());
		System.out.println(lastmonth);
		
		System.out.println("------");
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(curTime);
		int dayofMonth = c2.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayofMonth);
		
		System.out.println("------");
		Calendar c3 = Calendar.getInstance();
		c3.setTimeInMillis(curTime);
		c3.add(Calendar.DATE, 1);
		System.out.println(c3.getTimeInMillis());
		c3.add(Calendar.HOUR, c3.get(Calendar.HOUR)*-1);
		System.out.println(c3.getTimeInMillis());
		c3.add(Calendar.MINUTE, c3.get(Calendar.MINUTE)*-1);
		System.out.println(c3.getTimeInMillis());
		c3.add(Calendar.SECOND, c3.get(Calendar.SECOND)*-1);
		System.out.println(c3.getTimeInMillis());
		System.out.println(c3.getTimeInMillis()/1000);
		
		
		
		//////
		
		Calendar c4 = Calendar.getInstance();
		c4.setTimeInMillis(curTime);
		//Tomorrow, current
		c4.add(Calendar.DATE, 1);
		//Tomorrow, remove hours 
		System.out.println(c4.get(Calendar.HOUR_OF_DAY));
		c4.add(Calendar.HOUR_OF_DAY, c4.get(Calendar.HOUR_OF_DAY)*-1);
		//Tomorrow, remove minutes
		c4.add(Calendar.MINUTE, c4.get(Calendar.MINUTE)*-1);
		//Tomorrow, remove seconds
		c4.add(Calendar.SECOND, c4.get(Calendar.SECOND)*-1);

		long gap = c4.getTimeInMillis()-curTime;//In mill seconds
		
		int timeslot = (int) (gap/1000);//In seconds
		
		System.out.println(timeslot);
		System.out.println(curTime);
	}

}
