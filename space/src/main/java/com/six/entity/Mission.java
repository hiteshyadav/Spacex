package com.six.entity;

import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.six.constant.MissionStatus;
import com.six.constant.RocketStatus;
import com.six.constant.StringConstants;

public class Mission implements Comparable<Mission> {

	static Logger log = Logger.getLogger(Mission.class.getName()); 
	
	private String name;
	private MissionStatus status;
	private Set<Rocket> rockets;

	public Mission(String name) {
		this.name = name;
		status = MissionStatus.Scheduled;
		rockets = new TreeSet<Rocket>();
	}

	public MissionStatus getStatus() {
		return status;
	}

	public int compareTo(Mission o) {
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

	public void endMission() {
		for (Rocket r1 : rockets) {
			r1.endMission();
		}
		rockets = new TreeSet<Rocket>();
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

	public String getSummary() {
		

		StringBuilder sb = new StringBuilder();
		sb.append(name + StringConstants.separator + status + "-Dragons: " + rockets.size());
		sb.append(StringConstants.newLine);
		for (Rocket r1 : rockets) {
			sb.append(r1.getName() + StringConstants.separator + r1.getStatus());
			sb.append(StringConstants.newLine);
		}
		return sb.toString();
	}
}
