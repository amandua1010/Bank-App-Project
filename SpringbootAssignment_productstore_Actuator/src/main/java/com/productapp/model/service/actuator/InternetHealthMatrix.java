package com.productapp.model.service.actuator;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class InternetHealthMatrix implements HealthIndicator {

	@Override
	public Health health() {
		
		if(checkInternet() == true) {
			return Health.up().withDetail("success code", "active internet connection").build();
		}
		
		else {
			return Health.up().withDetail("error code", "not active internet connection").build();
		}
		
	}

	public boolean checkInternet() {
		
		boolean flag=false;
		
		try {
			
			URL url = new URL("https://www.google.co.in");
			URLConnection connection = url.openConnection();
			flag = true;
			
		}
		
		catch(Exception ex) {
			flag = false;
		}
		
		return flag;
		
	}
	
}
