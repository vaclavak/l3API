package vpp.vac.l3lib.util;

import java.util.HashMap;

public class IPEncoder {
	
	private static IPEncoder encoder = new IPEncoder();
	private HashMap<String, String> characterMap = new HashMap<String, String>();
	
	
	private IPEncoder() {
		characterMap.put("0", "A");
		characterMap.put("1", "B");
		characterMap.put("2", "C");
		characterMap.put("3", "D");
		characterMap.put("4", "E");
		characterMap.put("5", "F");
		characterMap.put("6", "G");
		characterMap.put("7", "H");
		characterMap.put("8", "I");
		characterMap.put("9", "J");
		characterMap.put(".", "N");
	}
	
	/**
	 * @return Returns the singleton instance of IPEncoder
	 */
	
	public static IPEncoder getEncoder() {
		return encoder;
	}
	
	
	public String encode(String x) {
		
		for(String s : characterMap.keySet()) {
			x = x.replace(s, characterMap.get(s));
		}
		
		return x;
		
	}
	
	
	public String decode(String x) {
		
		
		for(String s : characterMap.keySet()) {
			for(String s2 : characterMap.values()) {
				if(characterMap.get(s).equalsIgnoreCase(s2)) {
					x = x.replace(s2, s);
				}
			}
		}
		
		return x;
		
	}
	
	
	
	
	
	
}
