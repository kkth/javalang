package com.hk.trace;

/**
 * Created by kunhe on 1/23/18.
 */
public class MyStackTrace {
    public static void main(String[] args) {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getMethodName());
        }
    }
}
