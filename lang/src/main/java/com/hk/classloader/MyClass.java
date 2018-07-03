package com.hk.classloader;

import com.hk.deadlock.MyDeadLock1;

/**
 * Created by kunhe on 4/26/17.
 */
public class MyClass {
    public static void main(String[] args)
    {
        MyClass theClass = new MyClass();
        System.out.println(theClass.getClass().getClassLoader());

        String s = new String("Name");
        System.out.println(s.getClass().getClassLoader());
    }
}
