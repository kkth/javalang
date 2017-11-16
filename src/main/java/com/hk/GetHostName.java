package com.hk;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by kunhe on 11/16/16.
 */
public class GetHostName {
    public static void main(String[] args)
    {
        System.out.println("hello");
        String host="smtp.office365.com";
        try {
            InetAddress[] names = InetAddress.getAllByName(host);
            for (InetAddress name:names)
            {
               System.out.println(name);
               System.out.println(name.getHostAddress());
                System.out.println("\n");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
