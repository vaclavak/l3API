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
	  
	  private static final int ITERATIONS = 100000;
	  
	  private static final int KEY_LENGTH = 64;
	  
	  private static final int TIMESTAMP_LENGTH = 13;
	  
	  private static final int LETTERS_LENGTH = 8;
	  
	  private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  
	  private static final SecureRandom secureRandom = new SecureRandom();
	  
	  public static String generateLicenseKey(String secret) {
	    byte[] salt = new byte[16];
	    secureRandom.nextBytes(salt);
	    String saltStr = Base64.getUrlEncoder().withoutPadding().encodeToString(salt);
	    long timestamp = System.currentTimeMillis();
	    String timestampStr = String.format("%013d", new Object[] { Long.valueOf(timestamp) });
	    StringBuilder letters = new StringBuilder();
	    for (int i = 0; i < 8; i++)
	      letters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length()))); 
	    String lettersStr = letters.toString();
	    String data = saltStr + ":" + saltStr + ":" + timestampStr;
	    String hmac = computeHMAC(data, salt, secret);
	    return saltStr + ":" + saltStr + ":" + timestampStr + ":" + lettersStr;
	  }
	  
	  private static String computeHMAC(String data, byte[] salt, String secret) {
	    try {
	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
	      KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt, 100000, 512);
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

}
