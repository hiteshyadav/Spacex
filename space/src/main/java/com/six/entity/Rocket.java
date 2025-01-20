package com.six.entity;

import com.six.constant.RocketStatus;

public class Rocket {

	private String name;
	private RocketStatus status;
	
	public Rocket(String name) {
		this.name=name;
		status=RocketStatus.OnGroud;
	}

	public RocketStatus getStatus() {
		return status;
	}

	
	
}
