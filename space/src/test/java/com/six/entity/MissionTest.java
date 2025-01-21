package com.six.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.MissionStatus;

public class MissionTest {

	@Test
	public void testMissionStatus() {
		Mission m1 = new Mission("OG");
		assertEquals(MissionStatus.Scheduled, m1.getStatus());
	}
	
	@Test
	public void testMissionComparable() {
		Mission r1 = new Mission("Earth");
		Mission r2 = new Mission("Moon");
		int compRes = r1.compareTo(r2);
		
		assertEquals(compRes<0, true);
	}
}
