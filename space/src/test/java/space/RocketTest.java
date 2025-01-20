package space;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.RocketStatus;
import com.six.entity.Rocket;

public class RocketTest {

	@Test
	public void testRocketStatus() {
		Rocket r1 = new Rocket("VB");
		assertEquals(RocketStatus.OnGroud, r1.getStatus());
	}
}
