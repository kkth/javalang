package com.hk;

import java.util.HashMap;
import java.util.Map;

public class HashMapToString {
	private static String APP_KEY = "smsAppId";
	public static void main(String args[])
	{
		Map<String,Integer> theMap = new HashMap<String,Integer>();
		theMap.put("key1", 788);
		theMap.put("key2", -1);
		
		System.out.println(theMap);
		
		
		String str = "{key2=-1, key1=788}";
		String str2 = "sbad";
		String str3 = "";
		String str4 = null;
		String str5 = "";
		String str6 = "k";
		String str7 = "{}";
		String str8 = "{key=88}";
		String str9 = "{smsAppId=theID}";
		String str10 = "{key=,smsAppId=theID}";
		String str11 = "{key=,smsAppId=}";
		
		HashMapToString test = new HashMapToString();
		System.out.println(test.getAppDomainAndKey(str));
		//System.out.println(test.getAppDomainAndKey(str1));
		System.out.println(test.getAppDomainAndKey(str2));
		System.out.println(test.getAppDomainAndKey(str3));
		System.out.println(test.getAppDomainAndKey(str4));
		System.out.println(test.getAppDomainAndKey(str5));
		System.out.println(test.getAppDomainAndKey(str6));
		System.out.println(test.getAppDomainAndKey(str7));
		System.out.println(test.getAppDomainAndKey(str8));
		System.out.println(test.getAppDomainAndKey(str9));
		System.out.println(test.getAppDomainAndKey(str10));
		System.out.println(test.getAppDomainAndKey(str11));
	}
	
	public String getAppDomainAndKey(String mapString)
	{
		String ret = "";
		//At least 5 characters {k=v}
		if(mapString != null && mapString.length()>4)
		{
			String kvs = mapString.substring(1, mapString.length()-1);
			String[] subs  = kvs.split(",");
			if(subs != null)
			{
				for(String sub:subs)
				{
					String[] kv = sub.split("=");
					if(kv != null && kv.length==2)
					{
						if(kv[0].equals(APP_KEY) && kv[1] != null)
						{
							ret = kv[1];
						}
					}
				}
			}
		}
		return ret;
	}
}
