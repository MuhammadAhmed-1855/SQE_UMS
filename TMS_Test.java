import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class TMS_Test {

	@Test
	void test01() {
		Main main = new Main();
		String output = main.Systems(2, "FA21-BCS-030");
		assertEquals("Transport System.", output);
	}

	@Test
	void test02() {
		Main main = new Main();
		String output = main.Systems(5, "FA21-BCS-030");
		assertEquals("Exiting Management System.", output);
	}
	
	@Test
	void test03() {
		Main main = new Main();
		String output = main.Systems(7, "FA21-BCS-030");
		assertEquals("Invalid Input!", output);
	}

	@Test
	void test04() {
		TransportManagement transport = new TransportManagement();
		String output = transport.Choices(1, "FA21-BCS-030");
		assertEquals("Transport Services.", output);
	}

	@Test
	void test05() {
		TransportManagement transport = new TransportManagement();
		String output = transport.Choices(0, "FA21-BCS-030");
		assertEquals("Exiting Transport System.", output);
	}
	
	@Test
	void test06() {
		TransportManagement transport = new TransportManagement();
		String output = transport.Choices(2, "FA21-BCS-030");
		assertEquals("Invalid Input!", output);
	}
}
