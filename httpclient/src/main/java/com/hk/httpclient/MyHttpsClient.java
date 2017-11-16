package com.hk.httpclient;
/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.hk.httpclient.entity.AuthData;
import com.hk.httpclient.entity.GreetingData;
import com.hk.httpclient.entity.SDMKEntity;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

public class MyHttpsClient {

        public static void main(String[] args) throws Exception {

                CloseableHttpClient httpclient = HttpClients.createDefault();
                try {
                    //Get token
                        HttpGet httpGet = new HttpGet("http://it.dmk.tendcloud.com/account/tdmkaccount/authen/app/v2?apikey=a3879b34bad240b69a5228490b90e293&apitoken=7823aa48ddd24ef2b4cabe758dbf2273");
                        CloseableHttpResponse response = httpclient.execute(httpGet);
                        String token = getField(response,AuthData.class,"Token");

                        //Call service
                        BufferedReader in = new BufferedReader(new FileReader("/Users/kunhe/MyProjects/javalang/httpclient/name.txt"));
                        String line = null;
                        while((line = in.readLine()) != null)
                        {
                                HttpGet httpGet2 = new HttpGet("http://it.dmk.tendcloud.com/data/kun/greeting0831A?name=" + line);
                                httpGet2.setHeader(new BasicHeader("X-Access-Token",token));
                                CloseableHttpResponse response2 = httpclient.execute(httpGet2);
                                getField(response2,GreetingData.class,"Timestamp");
                        }

                        in.close();


                } finally {
                        httpclient.close();
                }
        }

        public static String getField(CloseableHttpResponse response, Class dataCalss,String fieldName)
        {
                String ret = "";
                try {
                        System.out.println(response.getStatusLine());
                        InputStream is = response.getEntity().getContent();
                        String content = IOUtils.toString(is, StandardCharsets.UTF_8);
                        System.out.println(content);


                        Gson json = new Gson();
                    //    Type theType = new TypeToken<SDMKEntity<T>>(){}.getType();
                        SDMKEntity theEnt = json.fromJson(content,SDMKEntity.class);
                        if(theEnt != null)
                        {
                                Object dataMap  = theEnt.getData();

                                String inStr = json.toJson(dataMap);
                                Object data = json.fromJson(inStr,dataCalss);

                                Method[] methods = data.getClass().getMethods();
                                for(Method m:methods)
                                {
                                        if(m.getName().equals("get"+fieldName))
                                        {
                                                ret = (String) m.invoke(data);
                                        }
                                }

                                System.out.println(ret);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (IllegalAccessException e) {
                        e.printStackTrace();
                } catch (InvocationTargetException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                response.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }

                return ret;
        }
}

