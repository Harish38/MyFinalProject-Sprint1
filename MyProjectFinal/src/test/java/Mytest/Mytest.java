package Mytest;

import org.junit.Test;

import healthcaresystemproject.dto.Appointment;
import junit.framework.TestCase;

public class Mytest extends TestCase {
	
Appointment a=new Appointment();

@Test
	public void testcase() {
		assertEquals(false,a.isApproved());
	}
}
