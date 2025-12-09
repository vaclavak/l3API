package vpp.vac.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L3apiApplication {
	
	private static String[] args;
	
	public static final String VERSION = "1.0";
	
	
	public static void main(String[] args) {
		L3apiApplication.args = args;
		SpringApplication.run(L3apiApplication.class, args);
		
		System.out.println("l3API " + VERSION);
		
		if(!(args.length > 0)) {
			System.out.println("Warning: No secret is specified, restart with a valid secret as argument 0");
		}
	}
	
	public static String[] getArgs() {
		if(args != null && args.length > 0) {
			return args;
		}
		
		Thread t = new Thread(() -> {
			while(true) {
				try {
				System.out.print("\rERROR: No secret specified! Using \"secret\" as secret   ");
				Thread.sleep(1000);
				System.out.print("\r...                                                      ");
				Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		
		return null;
	}

}
