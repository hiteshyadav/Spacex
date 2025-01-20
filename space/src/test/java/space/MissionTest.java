package space;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.six.constant.MissionStatus;
import com.six.entity.Mission;

public class MissionTest {

	@Test
	public void testMissionStatus() {
		Mission m1 = new Mission("OG");
		assertEquals(MissionStatus.Scheduled, m1.getStatus());
	}
}
