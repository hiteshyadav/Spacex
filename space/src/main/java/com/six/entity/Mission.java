package com.six.entity;

import com.six.constant.MissionStatus;

public class Mission {

	private String name;
	private MissionStatus status;

	public Mission(String name) {
		this.name = name;
		status=MissionStatus.Scheduled;
	}

	public MissionStatus getStatus() {
		return status;
	}

	
	
}
