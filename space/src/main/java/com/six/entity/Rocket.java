package com.six.entity;

import org.apache.log4j.Logger;

import com.six.constant.RocketStatus;

public class Rocket implements Comparable<Rocket> {

	static Logger log = Logger.getLogger(Rocket.class.getName());
	
	private String name;
	private RocketStatus status;
	private Mission mission;
	private boolean inRepair;
	private boolean endMission;

	public Rocket(String name) {
		this.name = name;
		status = RocketStatus.OnGroud;
		mission = null;
		endMission = false;
	}

	public String getName() {
		return name;
	}

	public boolean isInRepair() {
		return inRepair;
	}

	public void setInRepair(boolean inRepair) {
		this.inRepair = inRepair;
		updateRocketStatus();
	}

	public RocketStatus getStatus() {
		return status;
	}

	public void endMission() {
		mission = null;
		endMission = true;
//		updateRocketStatus();
	}

	public boolean assignMission(Mission mission) {
		boolean assignOperation = true;
		if (endMission) {
			assignOperation = false;
			log.warn("Rocket mission is already ended.");
		} else {
			if (!isAssigned()) {
				this.mission = mission;

			} else {
				assignOperation = false;
			}
		}

		updateRocketStatus();
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
		return other.name.compareTo(this.name);

	}

	public void updateRocketStatus() {
		if (isAssigned()) {
			if (inRepair) {
				status = RocketStatus.InRepair;
			} else {
				status = RocketStatus.InSpace;
			}
			this.mission.updateStatus();
		} else {
			status = RocketStatus.OnGroud;
		}
	}
}
