package com.productapp.model.service.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

@Service
@Endpoint(id="demoendpoint", enableByDefault = true)
public class MyEndPoint {
	
	@Autowired
	private InternetHealthMatrix internetHeathMatrix;
	
	@ReadOperation
	public MyEndPointResponse endPointResponse() {
		
		return new MyEndPointResponse(389, "demo custom actuator", "active", internetHeathMatrix.checkInternet());
	}
	
}
