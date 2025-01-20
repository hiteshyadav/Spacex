package com.six.entity;

import com.six.constant.RocketStatus;

public class Rocket {

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

}
