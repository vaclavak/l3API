package vpp.vac.l3lib.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class HTTPConnection {
	
	/**
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @param timeout The amount of milliseconds to wait before closing connection, 0 is considered infinite
	 * @return Returns the value of the specified json object from the specified URL
	 */
	
	public static String getJson(String URL, String name, int timeout) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setConnectTimeout(timeout);
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            String field = json.getString(name);

	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * 
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @return Returns the string value of the specified json object from the specified URL
	 */
	
	public static String getString(String URL, String name) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            String field = json.getString(name);

	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * 
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @param timeout The amount of milliseconds to wait before closing connection, 0 is considered infinite
	 * @return Returns the string value of the specified json object from the specified URL
	 */
	
	public static String getString(String URL, String name, int timeout) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setConnectTimeout(timeout);
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            String field = json.getString(name);

	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * 
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @return Returns the boolean value of the specified json object from the specified URL
	 */
	
	public static boolean getBoolean(String URL, String name) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            boolean field = json.getBoolean(name);

	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @param timeout The amount of milliseconds to wait before closing connection, 0 is considered infinite
	 * @return Returns the boolean value of the specified json object from the specified URL
	 */
	
	public static boolean getBoolean(String URL, String name, int timeout) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setConnectTimeout(timeout);
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            boolean field = json.getBoolean(name);

	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @return Returns the integer value of the specified json object from the specified URL
	 */
	
	public static int getInt(String URL, String name) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            int field = json.getInt(name);
	            
	            
	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return 1;
	}
	
	
	/**
	 * @param URL The URL of the endpoint containing the json object
	 * @param name The name of the json object that should be retrieved
	 * @param timeout The amount of milliseconds to wait before closing connection, 0 is considered infinite
	 * @return Returns the integer value of the specified json object from the specified URL
	 */
	
	public static int getInt(String URL, String name, int timeout) {
		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setConnectTimeout(timeout);
			
			
			 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder content = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                content.append(inputLine);
	            }

	            in.close();
	            connection.disconnect();

	            
	            JSONObject json = new JSONObject(content.toString());
	            int field = json.getInt(name);
	            
	            
	            return field;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return 1;
	}

}
