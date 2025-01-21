package com.six.entity;

import com.six.constant.RocketStatus;

public class Rocket implements Comparable<Rocket> {

	private String name;
	private RocketStatus status;
	Mission mission;
	boolean inRepair;

	public Rocket(String name) {
		this.name = name;
		status = RocketStatus.OnGroud;
		mission = null;
	}

	public boolean isInRepair() {
		return inRepair;
	}

	public void setInRepair(boolean inRepair) {
		this.inRepair = inRepair;
		updateRocketStatus(this.inRepair);
	}

	public RocketStatus getStatus() {
		return status;
	}

	public boolean assignMission(Mission mission) {
		boolean assignOperation = true;
		if (!isAssigned()) {
			this.mission = mission;

		} else {
			assignOperation = false;
		}

		updateRocketStatus(this.inRepair);

		return assignOperation;
	}

	private boolean isAssigned() {
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

	public void updateRocketStatus(boolean inRepair) {
		if (isAssigned()) {
			if (inRepair) {
				status = RocketStatus.InRepair;
			} else {
				status = RocketStatus.InSpace;
			}
			this.mission.updateStatus();
		}
	}
}
