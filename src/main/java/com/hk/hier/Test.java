package com.hk.hier;

/**
 * Created by kunhe on 4/19/17.
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        System.out.println(a.value);
        System.out.println(b.value);
        a.saySomething();
        b.saySomething();
    }

}
