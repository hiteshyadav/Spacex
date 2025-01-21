package com.six.entity;

import java.util.Set;
import java.util.TreeSet;

import com.six.constant.MissionStatus;

public class Mission {

	private String name;
	private MissionStatus status;
	Set<Rocket> rockets;
	
	public Mission(String name) {
		this.name = name;
		status=MissionStatus.Scheduled;
		rockets=new TreeSet<Rocket>();
	}

	public MissionStatus getStatus() {
		return status;
	}

	
	
}
