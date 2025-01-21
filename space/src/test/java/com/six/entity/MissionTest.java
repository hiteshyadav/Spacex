package com.six.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.MissionStatus;

public class MissionTest {

	@Test
	public void testMissionStatus() {
		Mission m1 = new Mission("OG");
		assertEquals("When mission started its status should be : ",MissionStatus.Scheduled, m1.getStatus());

		Rocket r1 = new Rocket("PSLV");
		m1.addRocket(r1);
		MissionStatus status = m1.getStatus();
		assertEquals( "When rocket is assigned to mission its status should be: ",MissionStatus.InProgress,status);

		r1.setInRepair(true);
		status = m1.getStatus();
		assertEquals("When rocket goes in repair mode mission status should be change to : ", MissionStatus.Pending,status);

		r1.setInRepair(false);
		status = m1.getStatus();
		assertEquals("When rocket gets repaired, mission status should be change to : ", MissionStatus.InProgress,status);

	}

	@Test
	public void testMissionComparable() {
		Mission m1 = new Mission("Earth");
		Mission m2 = new Mission("Moon");
		int compRes = m1.compareTo(m2);

		assertEquals(compRes < 0, true);
	}

	@Test
	public void testRocketAssign() {
		Mission m1 = new Mission("Earth");
		Rocket r1 = new Rocket("PSLV");

		m1.addRocket(r1);
		int size = m1.getRocketSize();

		assertEquals(size, 1);

		Rocket r2 = new Rocket("GSLV");
		m1.addRocket(r2);
		size = m1.getRocketSize();
		assertEquals(size, 2);

	}
}
