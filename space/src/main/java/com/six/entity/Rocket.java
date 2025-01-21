package com.six.entity;

import com.six.constant.RocketStatus;

public class Rocket implements Comparable<Rocket>{

	private String name;
	private RocketStatus status;
	Mission mission;

	public Rocket(String name) {
		this.name = name;
		status = RocketStatus.OnGroud;
		mission = null;
	}

	public RocketStatus getStatus() {
		return status;
	}

	public void assignMission(Mission mission) {
		if (!isAssigned()) {
			this.mission = mission;
		}
	}

	boolean isAssigned() {
		boolean isAssigned = true;
		if (mission == null) {
			isAssigned = false;
		}
		return isAssigned;
	}

	public int compareTo(Rocket other) {
		// TODO Auto-generated method stub
		return this.name.compareTo(other.name);
	}

}
