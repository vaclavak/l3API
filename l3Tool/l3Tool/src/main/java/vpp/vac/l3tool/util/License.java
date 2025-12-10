package vpp.vac.l3tool.util;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class License {
	
	private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 100_000;
    private static final int KEY_LENGTH = 64;
    private static final int TIMESTAMP_LENGTH = 13;
    private static final int LETTERS_LENGTH = 8;
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();
	  
	  public static String generateLicenseKey(String secret) {
	        byte[] salt = new byte[SALT_LENGTH];
	        secureRandom.nextBytes(salt);
	        String saltStr = Base64.getUrlEncoder().withoutPadding().encodeToString(salt);

	        long timestamp = System.currentTimeMillis();
	        String timestampStr = String.format("%013d", timestamp);

	        StringBuilder letters = new StringBuilder();
	        for (int i = 0; i < LETTERS_LENGTH; i++) {
	            letters.append(LETTERS.charAt(secureRandom.nextInt(LETTERS.length())));
	        }
	        String lettersStr = letters.toString();

	        String data = saltStr + ":" + timestampStr + ":" + lettersStr;
	        String hmac = computeHMAC(data, salt, secret);

	        return saltStr + ":" + timestampStr + ":" + lettersStr + ":" + hmac;
	    }
	  
	  private static String computeHMAC(String data, byte[] salt, String secret) {
	        try {
	            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
	            KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt, ITERATIONS, KEY_LENGTH * 8);
	            byte[] keyBytes = factory.generateSecret(spec).getEncoded();
	            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "HmacSHA512");
	            Mac mac = Mac.getInstance("HmacSHA512");
	            mac.init(keySpec);
	            byte[] hmacBytes = mac.doFinal(data.getBytes());
	            return Base64.getUrlEncoder().withoutPadding().encodeToString(hmacBytes);
	        } catch (Exception e) {
	            throw new RuntimeException("HMAC computation failed", e);
	        }
	    }
	  
	  public static String generateSecret() {
	    byte[] randomBytes = new byte[32];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(randomBytes);
	    String secret = Base64.getEncoder().withoutPadding().encodeToString(randomBytes);
	    return secret;
	  }
	  
	  public static boolean validateKey(String licenseKey, String secret) {
	        String[] parts = licenseKey.split(":");
	        if (parts.length != 4) return false;
	        String saltStr = parts[0];
	        String timestampStr = parts[1];
	        String lettersStr = parts[2];
	        String hmacStr = parts[3];
	        byte[] salt;
	        try {
	            salt = Base64.getUrlDecoder().decode(saltStr);
	        } catch (IllegalArgumentException e) {
	            return false;
	        }
	        if (salt.length != SALT_LENGTH) return false;
	        if (!timestampStr.matches("\\d{" + TIMESTAMP_LENGTH + "}")) return false;
	        if (lettersStr.length() != LETTERS_LENGTH || !lettersStr.matches("[A-Z0-9]{" + LETTERS_LENGTH + "}")) return false;
	        String data = saltStr + ":" + timestampStr + ":" + lettersStr;
	        String expectedHmac = computeHMAC(data, salt, secret);
	        if (!hmacStr.equals(expectedHmac)) return false;
	        long timestamp = Long.parseLong(timestampStr);
	        long now = System.currentTimeMillis();
	        if (timestamp > now || now - timestamp > 1000L * 60 * 60 * 24 * 365) return false;
	        return true;
	    }

}
