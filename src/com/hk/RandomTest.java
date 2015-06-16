package com.hk;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		for(int i =0;i<100;i++)
		{
		//Generate random number
		int randInt = Math.abs(random.nextInt())%1000000;
		int transInt = Math.abs(random.nextInt())%100000000;
		
		String rand = String.format("%06d",randInt);
		String trans = String.format("%08d",transInt);
		
		System.out.println(rand + "_" + trans);
		
		}
		
		
	}

}
