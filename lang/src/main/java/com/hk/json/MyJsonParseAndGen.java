package com.hk.json;

import com.google.gson.Gson;
import com.hk.json.enttiy.MyType;
import com.hk.json.enttiy.MyType2;

/**
 * Created by kunhe on 7/10/17.
 */
public class MyJsonParseAndGen {

    public static void main(String[] args)
    {
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
       // MyType target = new MyType(101,"Kun",90);
       // String json = gson.toJson(target); // serializes target to Json
       //System.out.println(json);
        String oldJson="{\"intVal\":101,\"strVal\":\"Kun\",\"dVal\":90.202}";
        MyType2 target2 = gson.fromJson(oldJson, MyType2.class); // deserializes json into target2

        System.out.println(gson.toJson(target2));

    }
}
