package com.six.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.RocketStatus;

public class RocketTest {

	@Test
	public void testRocketStatus() {
		Rocket r1 = new Rocket("VB");
		assertEquals(RocketStatus.OnGroud, r1.getStatus());

		Mission m1 = new Mission("Earth");
		r1.assignMission(m1);
		RocketStatus status = r1.getStatus();
		assertEquals(status, RocketStatus.InSpace);

		r1.setInRepair(true);
		status = r1.getStatus();
		assertEquals(status, RocketStatus.InRepair);
	}

	@Test
	public void testRocketComparable() {
		Rocket r1 = new Rocket("VB");
		Rocket r2 = new Rocket("BV");
		int compRes = r1.compareTo(r2);

		assertEquals(compRes > 0, true);
	}

	@Test
	public void testRocketAssignToMission() {
		Rocket r1 = new Rocket("PSLV");
		Mission m1 = new Mission("Earth");

		boolean res = r1.assignMission(m1);
		assertEquals(res, true);

		Mission m2 = new Mission("Moon");
		res = r1.assignMission(m2);
		assertEquals(res, false);
	}
}
