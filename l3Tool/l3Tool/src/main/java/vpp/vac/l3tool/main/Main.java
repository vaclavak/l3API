package vpp.vac.l3tool.main;

import java.util.ArrayList;

import vpp.vac.l3tool.argument.Argument;
import vpp.vac.l3tool.util.License;

public class Main {
	
	public static ArrayList<Argument> argumentList = new ArrayList<Argument>();
	
	public static void main(String[] args) {
		
		if(!(args.length > 0)) {
			System.out.println("No arguments specified");
			return;
		}
		
		
		Argument generate = new Argument("generate", () -> {
	          if (args.length >= 2) {
	            System.out.println(License.generateLicenseKey(args[1]));
	            return;
	          } 
	          System.out.println("Please specify secret");
	        }, argumentList);
	    Argument generateSecret = new Argument("generateSecret", () -> System.out.println(License.generateSecret()), argumentList);
	    Argument verifyKey = new Argument("validate", () -> {
	    	if(args.length >= 2) {
	    		System.out.println(License.validateKey(args[2], args[1]));
	    		return;
	    	}
	    	
	    	System.out.println("Please specify secret and key");
	    	
	    	
	    }, argumentList);
	    for (Argument a : argumentList) {
	      if (args[0].equalsIgnoreCase(a.getName()) || args[0].equalsIgnoreCase("-" + a.getName())) {
	        a.run();
	      	return;
	      }
	    }
	    
	    System.out.println("Unknown argument");
	}

}
