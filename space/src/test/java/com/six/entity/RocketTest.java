package com.six.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.RocketStatus;

public class RocketTest {

	@Test
	public void testRocketStatus() {
		Rocket r1 = new Rocket("VB");
		assertEquals(" Initial status of record should be grounded : ", RocketStatus.OnGroud, r1.getStatus());

		Mission m1 = new Mission("Earth");
		r1.assignMission(m1);
		RocketStatus status = r1.getStatus();
		assertEquals("When rocket is assign to mission its status must be updated : ", RocketStatus.InSpace, status);

		r1.setInRepair(true);
		status = r1.getStatus();
		assertEquals("When rocket goes into repair mode its status should be : ", RocketStatus.InRepair, status);
	}

	@Test
	public void testRocketComparable() {
		Rocket r1 = new Rocket("VB");
		Rocket r2 = new Rocket("BV");
		int compRes = r1.compareTo(r2);

		assertEquals(compRes < 0, true);
	}

	@Test
	public void testRocketAssignToMission() {
		Rocket r1 = new Rocket("PSLV");
		Mission m1 = new Mission("Earth");

		boolean res = r1.assignMission(m1);
		assertEquals("Initially rocket should be assign to at least one mission, ", true, res);

		Mission m2 = new Mission("Moon");
		res = r1.assignMission(m2);
		assertEquals("Rocket should not be assign to multiple mission : ", false, res);

		r1.endMission();
		res = r1.assignMission(m1);
		assertEquals("RocketMission is ended,now  it should not be assign to any other mssion", false, res);

	}
}
