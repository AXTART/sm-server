package com.secretmessage.smserver;



import org.apache.tomcat.util.buf.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetHash {
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String separ(int a, int b, String input){
        if(a > b){
            int swap = b;
            b = a;
            a = swap;
        }
        else if( a == b){
            return "";
        }
        String output = "";
        for (;a<b;a++){
            if (a <= input.length()) {
                String character = String.valueOf(input.charAt(a));
                output += character;
            }
        }
        return output;
    }

    private static String sha256(String input){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encodedhash = digest.digest(
                input.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    static String token(String username, long id, String uuid) {
            String user_hash = sha256(username);
            String id_hash = sha256(String.valueOf(id));
            String uuid_hash = sha256(uuid);
            String token = "";

            token += separ(0,10,user_hash);
            token += separ(user_hash.length()-10,user_hash.length(),user_hash);

            token += separ(0,10,id_hash);
            token += separ(id_hash.length()-10,id_hash.length(),id_hash);

            token += separ(0,10,uuid_hash);
            token += separ(uuid_hash.length()-10,uuid_hash.length(),uuid_hash);

            return token;
    }
}
