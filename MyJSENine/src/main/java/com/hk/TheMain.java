package com.hk;

import java.util.List;

/**
 * Created by kunhe on 9/30/17.
 */
public class TheMain {

    public static void main() {
        TheMain exec = new TheMain();
        exec.cal();
    }

    void int cal(List<Integer> source, int threshold) {
        int ret = 0;
        Integer val = 0;
        for(source:val) {
            if(val >threshold) {
              ret++;
            }
        }

        return ret;
    }


}
