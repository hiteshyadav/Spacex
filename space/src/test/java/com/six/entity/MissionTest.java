package com.six.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.six.constant.MissionStatus;
import com.six.constant.RocketStatus;
import com.six.constant.StringConstants;

public class MissionTest {

	@Test
	public void testMissionStatus() {
		Mission m1 = new Mission("OG");
		assertEquals("When mission started its status should be : ", MissionStatus.Scheduled, m1.getStatus());

		Rocket r1 = new Rocket("PSLV");
		m1.addRocket(r1);
		MissionStatus status = m1.getStatus();
		assertEquals("When rocket is assigned to mission its status should be: ", MissionStatus.InProgress, status);

		r1.setInRepair(true);
		status = m1.getStatus();
		assertEquals("When rocket goes in repair mode mission status should be change to : ", MissionStatus.Pending,
				status);

		r1.setInRepair(false);
		status = m1.getStatus();
		assertEquals("When rocket gets repaired, mission status should be change to : ", MissionStatus.InProgress,
				status);

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

	@Test
	public void testEndMission() {

		Mission m1 = new Mission("Earth");
		Rocket r1 = new Rocket("PSLV");

		m1.addRocket(r1);
		int size = m1.getRocketSize();

		assertEquals(size, 1);

		m1.endMission();
		size = m1.getRocketSize();
		assertEquals("When mission ends it should not contain any rockets : ", 0, size);
	}

	@Test
	public void testMissionSummary() {
		Mission m1 = new Mission("Earth");
		String res = m1.getSummary();
		String expectedRes = "Earth" + StringConstants.separator + "Scheduled" + "-Dragons: 0";
		expectedRes=expectedRes+StringConstants.newLine;
		
		assertTrue(expectedRes.equals(res));


		Rocket r1 = new Rocket("PSLV");
		Rocket r2 = new Rocket("GSLV");
		m1.addRocket(r1);
		m1.addRocket(r2);
		res = m1.getSummary();
		

		expectedRes = "Earth" + StringConstants.separator + "InProgress" + "-Dragons: 2";
		expectedRes=expectedRes+StringConstants.newLine;
		expectedRes = expectedRes + "PSLV" + StringConstants.separator + RocketStatus.InSpace;
		expectedRes = expectedRes + StringConstants.newLine;
		expectedRes = expectedRes + "GSLV" + StringConstants.separator + RocketStatus.InSpace;
		expectedRes = expectedRes + StringConstants.newLine;
		
		assertEquals(" Rockets should be in alph order :", expectedRes, res);

	}
}
