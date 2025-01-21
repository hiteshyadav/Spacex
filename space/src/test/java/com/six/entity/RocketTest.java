package com.six.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.RocketStatus;

public class RocketTest {

	@Test
	public void testRocketStatus() {
		Rocket r1 = new Rocket("VB");
		assertEquals(RocketStatus.OnGroud, r1.getStatus());
	}

	@Test
	public void testRocketComparable() {
		Rocket r1 = new Rocket("VB");
		Rocket r2 = new Rocket("BV");
		int compRes = r1.compareTo(r2);
		
		assertEquals(compRes>0, true);
	}
}
