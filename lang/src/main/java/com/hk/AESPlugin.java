package com.hk;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class AESPlugin {
    public static final String DEFAULT_CODING = "utf-8";
    public static final String KEY_SDK = "smsauthsdk";
    public static final String KEY_SVR = "smsauthsvr";

    public static String decrypt(String encrypted,boolean sdk) throws Exception {
        byte[] keyb  = null;
        if(sdk)
        {
        	keyb = KEY_SDK.getBytes(DEFAULT_CODING);
        }
        else
        {
        	keyb = KEY_SVR.getBytes(DEFAULT_CODING);
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(keyb);
        SecretKeySpec skey = new SecretKeySpec(thedigest, "AES");
        Cipher dcipher = Cipher.getInstance("AES");
        dcipher.init(Cipher.DECRYPT_MODE, skey);

        byte[] clearbyte = dcipher.doFinal(toByte(encrypted));
        return new String(clearbyte);
    }

    public static String encrypt(String domain,String appid,boolean sdk) throws Exception {

        byte[] input = (domain + "_" + appid).getBytes(DEFAULT_CODING);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = null;
        if(sdk)
        {
        	thedigest = md.digest(KEY_SDK.getBytes(DEFAULT_CODING));
        }
        else
        {
        	thedigest = md.digest(KEY_SVR.getBytes(DEFAULT_CODING));
        }
        SecretKeySpec skc = new SecretKeySpec(thedigest, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skc);

        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return interception(parseByte2HexStr(cipherText));
    }

    private static String interception(String str) {
        if (str.length() >= 96) {
            return str.substring(8, 16) + str.substring(48, 64) + str.substring(80, 88);
        } else if (str.length() >= 32) {
            return str.substring(0, 32);
        }
        return str;
    }

    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
                    16).byteValue();
        }
        return result;
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
    	System.out.println(AESPlugin.encrypt("adtracking","B0036206447B31BB857392B6D06159B7",true));
    	System.out.println(AESPlugin.encrypt("adtracking","B0036206447B31BB857392B6D06159B5",true));
    	System.out.println(AESPlugin.encrypt("adtracking","abcdefgAppID0529_4",true));
    	System.out.println(AESPlugin.encrypt("adtracking","abcdefgAppID0529_3",true));
    	System.out.println(AESPlugin.encrypt("adtracking","B0036206447B31BB857392B6D06159B7",false));
    	
    	//System.out.println(AESPlugin.decrypt("00000000000000000000000000000000"));
    }
}
