package vpp.vac.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vpp.vac.util.License;

@RestController
@RequestMapping("/api/license")
public class LicenseHandler {
	
	public License license;
	
	@GetMapping("/verify/{arg}")
	public Map<String, Boolean> getValid(@PathVariable("arg") String arg){
		
		license = (L3apiApplication.getArgs() != null && L3apiApplication.getArgs().length > 0) ? new License(L3apiApplication.getArgs()[0]) : new License("secret");
		LocalTime now = LocalTime.now();
		LocalDate date = LocalDate.now();
		
		
		System.out.println("[" + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + "]" + " [" + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + "] Validation request for " + arg + " | valid " + license.validateKey(arg) + "\n");
		return Map.of("valid", license.validateKey(arg));
	}
}
