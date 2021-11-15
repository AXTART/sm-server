package com.secretmessage.smserver.Util;



import com.secretmessage.smserver.Model.User;

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

    public static String sha256(String input){
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

    static String token(User user_to_hash) {
            // TODO: Change method to ensure that tokens won't repeat and that they are secure
            String username = user_to_hash.getUsername();
            String uuid = user_to_hash.getUuid().toString();

            String user_hash = sha256(username);
            String uuid_hash = sha256(uuid);
            String token = "";

            token += separ(0,10,user_hash);
            token += separ(user_hash.length()-10,user_hash.length(),user_hash);

            token += separ(0,10,uuid_hash);
            token += separ(uuid_hash.length()-10,uuid_hash.length(),uuid_hash);

            return token;
    }
}
