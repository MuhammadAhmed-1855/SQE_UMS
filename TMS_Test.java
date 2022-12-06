import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

class TMS_Test {
//
//	@Test
//	void test01() {
//		Main main = new Main();
//		String output = main.Systems(2, "FA21-BCS-030");
//		assertEquals("Transport System.", output);
//	}
//
//	@Test
//	void test02() {
//		Main main = new Main();
//		String output = main.Systems(5, "FA21-BCS-030");
//		assertEquals("Exiting Management System.", output);
//	}
//	
//	@Test
//	void test03() {
//		Main main = new Main();
//		String output = main.Systems(7, "FA21-BCS-030");
//		assertEquals("Invalid Input!", output);
//	}
//
//	@Test
//	void test04() {
//		TransportManagement transport = new TransportManagement();
//		String output = transport.Choices(1, "FA21-BCS-030");
//		assertEquals("Transport Services.", output);
//	}
//
//	@Test
//	void test05() {
//		TransportManagement transport = new TransportManagement();
//		String output = transport.Choices(0, "FA21-BCS-030");
//		assertEquals("Exiting Transport System.", output);
//	}
//	
//	@Test
//	void test06() {
//		TransportManagement transport = new TransportManagement();
//		String output = transport.Choices(2, "FA21-BCS-030");
//		assertEquals("Invalid Input!", output);
//	}
//
//	@Test
//	void test07() {
//		TMS services = new TMS();
//		String output = services.Choices(1, "FA21-BCS-030");
//		assertEquals("Bus Routes!", output);
//	}
//	
//	@Test
//	void test08() {
//		TMS services = new TMS();
//		String output = services.Choices(9, "FA21-BCS-030");
//		assertEquals("Invalid Input!", output);
//	}
//	
//	@Test
//	void test09() {
//		TMS services = new TMS();
//		String output = services.Choices(0, "FA21-BCS-030");
//		assertEquals("Exiting Transport Services!", output);
//	}
//	
//	@Test
//	void test10() {
//		TMS services = new TMS();
//		String output = services.Choices(2, "FA21-BCS-030");
//		assertEquals("Bus Fees!", output);
//	}
//	
//	@Test
//	void test11() {
//		TMS services = new TMS();
//		String output = services.Choices(3, "FA21-BCS-030");
//		assertEquals("Bus Already Registered!", output);
//	}
//
//	@Test
//	void testcreator() {
//		TMS services = new TMS();
//		String output = services.Choices(3, "FA21-BCS-034");
//		/*
//		 * String should have an no bus registered.
//		 * Example input in console.
//		 * Enter route = "8".
//		 * Enter stop = "Bhander".
//		 * Enter pick up = "1".
//		 * Enter drop off = "3".
//		 * 
//		 */
//		assertEquals("Bus Registration Successful!", output);
//	}
//	
//	@Test
//	void test12() {
//		TMS services = new TMS();
//		String output = services.Choices(3, "FA21-BCS-032");
//		/*
//		 * String should have an no bus registered.
//		 * Example input in console.
//		 * Enter route = "8".
//		 * Enter stop = "Bhander".
//		 * Enter pick up = "1".
//		 * Enter drop off = "3".
//		 * 
//		*/
//		assertEquals("Bus Registration Successful!", output);
//	}
//	
//	@Test
//	void test13() {
//		TMS services = new TMS();
//		String output = services.Choices(3, "FA21-BCS-099");
//
//		/*
//		 * String should have a bus registered.
//		 * Example input in console.
//		 * Enter route = "8".
//		 * Enter stop = "Bhander".
//	 	 * Enter pick up = "1".
//	 	 * Enter drop off = "3".
//	     * 
//		*/
//		assertEquals("Information Update Successful!", output);
//	}
//	
//	@Test
//	void test14() {
//		TMS services = new TMS();
//		String output = services.Choices(4, "FA21-BCS-033");
//		assertEquals("No Bus Registered.", output);
//	}
//	
//	@Test
//	void test15() {
//		TMS services = new TMS();
//		String output = services.Choices(5, "FA21-BCS-056");
//		assertEquals("No Bus Registered!", output);
//	}
//	
//	@Test
//	void test16() {
//		TMS services = new TMS();
//		String output = services.Choices(6, "FA21-BCS-037");
//		assertEquals("No Bus Registration File Found!", output);
//	}
//	
//	@Test
//	void test17() {
//		TMS services = new TMS();
//		String output = services.Choices(6, "FA21-BCS-099");
//		assertEquals("Fee Not Paid!", output);
//	}
//	
//	@Test
//	void test18() {
//		TMS services = new TMS();
//		String output = services.Choices(7, "FA21-BCS-099");
//		assertEquals("Bus Registration Deleted!", output);
//	}
//	
//	@Test
//	void test19() {
//		TMS services = new TMS();
//		String output = services.Choices(7, "FA21-BCS-099");
//		assertEquals("No Bus Registration File Found!", output);
//	}
//	
//	@Test
//	void test20() {
//		TMS services = new TMS();
//		boolean output = services.busFileFound("FA21-BCS-030");
//		assertEquals(true, output);
//	}
//	
//	@Test
//	void test21() {
//		TMS services = new TMS();
//		boolean output = services.busFileFound("FA21-BCS-232");
//		assertEquals(false, output);
//	}
//	
//	@Test
//	void test22() {
//		TMS services = new TMS();
//		String output = services.busFee("1");
//		assertEquals("20000", output);
//	}
//	
//	@Test
//	void  test23() {
//		TMS services = new TMS();
//		String output = services.busFee("2");
//		assertEquals("15000", output);
//	}
//	
//	@Test
//	void  test24() {
//		TMS services = new TMS();
//		String output = services.busFee("3");
//		assertEquals("14000", output);
//	}
//	
//	@Test
//	void  test25() {
//		TMS services = new TMS();
//		String output = services.busFee("4");
//		assertEquals("13000", output);
//	}
//	
//	@Test
//	void test26() {
//		TMS services = new TMS();
//		String output = services.busFee("5");
//		assertEquals("10000", output);
//	}
//	
//	@Test
//	void  test27() {
//		TMS services = new TMS();
//		String output = services.busFee("6");
//		assertEquals("22000", output);
//	}
//	
//	@Test
//	void  test28() {
//		TMS services = new TMS();
//		String output = services.busFee("7");
//		assertEquals("24000", output);
//	}
//	
//	@Test
//	void  test29() {
//		TMS services = new TMS();
//		String output = services.busFee("8");
//		assertEquals("21000", output);
//	}
//	
//	@Test
//	void  test30() {
//		TMS services = new TMS();
//		String output = services.busFee("Soan");
//		assertEquals("", output);
//	}
//
//	@Test
//	void  test31() {
//		TMS services = new TMS();
//		String output = services.busFee("9");
//		assertEquals("", output);
//	}
//
//	@Test
//	void test32() {
//		TMS services = new TMS();
//		String output = services.RouteChecker("a");
//		assertEquals("Enter valid route no!", output);
//	}
//	
//	@Test
//	void test33() {
//		TMS services = new TMS();
//		String output = services.RouteChecker("9");
//		assertEquals("Enter valid route no!", output);
//	}
//	
//	@Test
//	void test34() {
//		TMS services = new TMS();
//		String output = services.RouteChecker("8");
//		assertEquals("8", output);
//	}
//
//	@Test
//	void test35() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Bhander","a");
//		assertEquals("Enter valid stop name!", output);
//	}
//	
//	@Test
//	void test36() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Bhander","9");
//		assertEquals("Enter valid stop name!", output);
//	}
//	
//	@Test
//	void test37() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Bhander","8");
//		assertEquals("Bhander", output);
//	}
//	@Test
//	void test38() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Golra More","a");
//		assertEquals("Enter valid stop name!", output);
//	}
//	
//	@Test
//	void test39() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Golra More","9");
//		assertEquals("Enter valid stop name!", output);
//	}
//	
//	@Test
//	void test40() {
//		TMS services = new TMS();
//		String output = services.StopChecker("Golra More","8");
//		assertEquals("Enter valid stop name!", output);
//	}
//	
//	@Test
//	void test41() {
//		TMS services = new TMS();
//		String output = services.DropOffChecker("a");
//		assertEquals("Kindly enter valid input!", output);
//	}
//	
//	@Test
//	void test42() {
//		TMS services = new TMS();
//		String output = services.DropOffChecker("9");
//		assertEquals("Kindly enter valid input!", output);
//	}
//	
//	@Test
//	void test43() {
//		TMS services = new TMS();
//		String output = services.DropOffChecker("1");
//		assertEquals("1:30 PM", output);
//	}
//	
//	@Test
//	void test44() {
//		TMS services = new TMS();
//		String output = services.DropOffChecker("2");
//		assertEquals("2:30 PM", output);
//	}
//	
//	@Test
//	void test45() {
//		TMS services = new TMS();
//		String output = services.DropOffChecker("3");
//		assertEquals("5:30 PM", output);
//	}
//	
//	@Test
//	void test46() {
//		TMS services = new TMS();
//		String output = services.PickUpChecker("a");
//		assertEquals("Kindly enter valid input!", output);
//	}
//	
//	@Test
//	void test47() {
//		TMS services = new TMS();
//		String output = services.PickUpChecker("9");
//		assertEquals("Kindly enter valid input!", output);
//	}
//	
//	@Test
//	void test48() {
//		TMS services = new TMS();
//		String output = services.PickUpChecker("1");
//		assertEquals("8 AM", output);
//	}
//	
//	@Test
//	void test49() {
//		TMS services = new TMS();
//		String output = services.PickUpChecker("2");
//		assertEquals("10 AM", output);
//	}
//	
//	@Test
//	void test50() {
//		TMS services = new TMS();
//		String output = services.PickUpChecker("3");
//		assertEquals("12 AM", output);
//	}
//
////	
//	//Fee payment and after cases.
//	@Test
//	void test51() {
//		TMS services = new TMS();
//		String output = services.Choices(5, "FA21-BCS-030");
//		assertEquals("Fee Paid!", output);
//	}
//	
//	@Test
//	void test52() {
//		TMS services = new TMS();
//		String output = services.Choices(5, "FA21-BCS-030");
//		assertEquals("Fee Already Paid!", output);
//	}
//	
//	@Test
//	void test53() {
//		TMS services = new TMS();
//		String output = services.Choices(6, "FA21-BCS-032");
//		assertEquals("Displaying Bus Profile Successful!", output);
//	}
//	
//	@Test
//	void test54() {
//		TMS services = new TMS();
//		String output = services.Choices(7, "FA21-BCS-032");
//		assertEquals("Bus Registration Deleted!", output);
//	}
//	
//	@Test
//	void test55() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.displayRoutesAndStops();
//        String c = outContent.toString();
//		assertThat(c, containsString("Bhander"));
//	}
//	
//	@Test
//	void test56() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.displayBusFees();
//        String c = outContent.toString();
//		assertThat(c, containsString("Route 8 : 21,000"));
//	}
//	
//	@Test
//	void test57() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.busRoute();
//        String c = outContent.toString();
//		assertThat(c, containsString("Enter your route :"));
//	}
//	
//	@Test
//	void test58() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.busDropOff();
//        String c = outContent.toString();
//		assertThat(c, containsString("Enter your preferred timing for drop-off"));
//	}
//	
//	@Test
//	void test59() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.busStop("8");
//        String c = outContent.toString();
//		assertThat(c, containsString("Enter the stop name :"));
//	}
//
//	@Test
//	void test60() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.busPickUp();
//        String c = outContent.toString();
//		assertThat(c, containsString("Enter your preferred timing for pick-up"));
//	}
//	
//	@Test
//	void test61() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.busRegistration("FA21-BCS-037");
//        String c = outContent.toString();
//		assertThat(c, containsString("Enter your route :"));
//	}
//	
//	@Test
//	void test62() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        TMS services = new TMS();
//        services.paymentMethod(true);
//        String c = outContent.toString();
//		assertThat(c, containsString("Select your payment method"));
//	}
//	
//	@Test
//	void test63() {
//		TMS services = new TMS();
//		boolean flag = services.busFileFound("FA21-BCS-037");
//		assertFalse(flag);
//	}
//	
//	@Test
//	void test64() {
//		TMS services = new TMS();
//		boolean flag = services.busFileFound("FA21-BCS-030");
//		assertTrue(flag);
//	}
//	
//	@Test
//	void test65() {
//		TMS services = new TMS();
//		String [] route_1 = {"F-11 Markaz","Margala road","Golra More","PAF Complex Gate","Shaheen Chowk","Madina Market"};
//		String[] output = services.routesNameStr("1");
//		Assert.assertArrayEquals( route_1, output);
//	}
//	
//	@Test
//	void test66() {
//		TMS services = new TMS();
//		String [] route_2 = {"G-11/2 Apple School","G-11 Markaz","G-11/3 Alladin Market","G-10 Umer Market","G-9/1 Street no 44"};
//		String[] output = services.routesNameStr("2");
//		Assert.assertArrayEquals( route_2, output);
//	}
//	
//	@Test
//	void test67() {
//		TMS services = new TMS();
//        String [] route_3 = {"Askari XI","Qasim Market","Roomi Market","GPO Saddar","Kacheri Chowk"};
//		String[] output = services.routesNameStr("3");
//		Assert.assertArrayEquals( route_3, output);
//	}
//	
//	@Test
//	void test68() {
//		TMS services = new TMS();
//        String [] route_4 = {"Hajj Complex","Old Daewoo Stop","Pirdhadhai More","Charing Cross","Valley Road"};
//        String[] output = services.routesNameStr("4");
//		Assert.assertArrayEquals( route_4, output);
//	}
//	
//	@Test
//	void test69() {
//		TMS services = new TMS();
//        String [] route_5 = {"Chungi no 22","CMH","502 workshop","Jinnah Park","Jhandha Chechi"};
//		String[] output = services.routesNameStr("5");
//		Assert.assertArrayEquals( route_5, output);
//	}
//	
//	@Test
//	void test70() {
//		TMS services = new TMS();
//        String [] route_6 = {"Bahria Town Ace Academy","Street no 6 Bahria More","Al Noor Pharmacy","Rahat Bakery","PWD Barrier","London Tradex"};
//        String[] output = services.routesNameStr("6");
//		Assert.assertArrayEquals( route_6, output);
//	}
//	
//	@Test
//	void test71() {
//		TMS services = new TMS();
//        String [] route_7 = {"Gangal East","karal Chowk","Gangal West","Fizaya Colony","Chatry Chowk","Khanna Pull"};
//		String[] output = services.routesNameStr("7");
//		Assert.assertArrayEquals( route_7, output);
//	}
//	
//	@Test
//	void test72() {
//		TMS services = new TMS();
//        String [] route_8 = {"Nawal Anchorage","Bhander","Sowan Garden","Al Shifa Hospital","Toyota Motors"};
//		String[] output = services.routesNameStr("8");
//		Assert.assertArrayEquals( route_8, output);
//	}
//	
//	@Test
//	void test73() {
//		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        Main obj = new Main();
//        obj.management("FA21-BCS-037");
//        String c = outContent.toString();
//		assertThat(c, containsString("Transport Management"));
//	}
}
