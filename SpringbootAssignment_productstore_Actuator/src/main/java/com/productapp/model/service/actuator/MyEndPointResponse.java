package com.productapp.model.service.actuator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyEndPointResponse {
	
	private int id;
	private String name;
	private String statusMsg;
	private boolean status;
	
}
