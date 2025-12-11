package vpp.vac.l3lib.util;

public class L3ServerComponent {
	
	private String url;
	private String key;
	
	
	public L3ServerComponent(String url, String key) {
		this.url = url;
		this.key = key;
	}
	
	
	public String getURL() {
		return this.url;
	}
	
	public String getKey() {
		return this.key;
	}

}
