package com.hk;

/**
 * Created by kunhe on 5/27/17.
 */
public class IntegerCache {

    public static void main(String[] args)
    {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1==i2);
        System.out.println(i3==i4);

        System.out.println(i1.equals(i2));
        System.out.println(i3.equals(i4));
    }
}
