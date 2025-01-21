package com.six.entity;

import java.util.Set;
import java.util.TreeSet;

import com.six.constant.MissionStatus;

public class Mission implements Comparable<Mission>{

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

	public int compareTo(Mission o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	
	
}
