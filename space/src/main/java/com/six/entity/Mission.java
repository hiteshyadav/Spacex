package com.six.entity;

import java.util.Set;
import java.util.TreeSet;

import com.six.constant.MissionStatus;
import com.six.constant.RocketStatus;

public class Mission implements Comparable<Mission> {

	private String name;
	private MissionStatus status;
	Set<Rocket> rockets;

	public Mission(String name) {
		this.name = name;
		status = MissionStatus.Scheduled;
		rockets = new TreeSet<Rocket>();
	}

	public MissionStatus getStatus() {
		return status;
	}

	public int compareTo(Mission o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	public void addRocket(Rocket r1) {
		if (r1.assignMission(this)) {
			this.rockets.add(r1);
		}
		updateStatus();
	}

	public int getRocketSize() {
		return rockets.size();
	}

	
	 void updateStatus() {
		if (rockets.size() == 0) {
			status = MissionStatus.Scheduled;
		} else if (rockets.size() >= 1) {
			int inRepairCount = 0;
			for (Rocket r1 : rockets) {
				if (r1.getStatus().equals(RocketStatus.InRepair)) {
					inRepairCount = inRepairCount + 1;
				}
			}
			if (inRepairCount >= 1) {
				status = MissionStatus.Pending;
			} else {
				status = MissionStatus.InProgress;
			}

		}
	}
}
