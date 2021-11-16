package com.secretmessage.smserver.util;



import com.secretmessage.smserver.model.User;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class GetHash {

    public static String randomHex(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }

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

    public static String hmacSha256(String secretKey, String message) {
        byte[] hmacSha256 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return bytesToHex(hmacSha256);
    }

    public static String token(User user) {
            String L = sha256(user.getUuid() + user.getPassword());
            String R = hmacSha256(user.getPassword(), L);
            return L + "." + R;
    }
}
