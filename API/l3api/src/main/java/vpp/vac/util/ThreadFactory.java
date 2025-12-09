package vpp.vac.util;

public class ThreadFactory {
	
	public static Thread newPrintThread(String message, int timeout) {
		Thread t = new Thread(() -> {
			while(true) {
				System.out.println(message);
				try {
					Thread.sleep(timeout);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		return t;
	}
	
	public static Thread newPrintThread(String message, String message2, int timeout) {
		Thread t = new Thread(() -> {
			while(true) {
				try {
				System.out.print(message);
				Thread.sleep(timeout);
				System.out.print(message2);
				Thread.sleep(timeout);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		return t;
	}

}
