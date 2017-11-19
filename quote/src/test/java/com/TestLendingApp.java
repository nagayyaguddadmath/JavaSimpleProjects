package com;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestLendingApp 
{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	final static String strPathOfInputFile = System.getProperty("user.dir") + 
			"\\src\\test\\resources\\" + "market.csv";

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testGivenExample()
	{
		String[] args = {strPathOfInputFile, "1000"};
		try {
			MainApplication.main(args);
			assertTrue(checkContent(MainApplication.REQAMOUNTSTRING + "1000"));
			assertTrue(checkContent(MainApplication.RATESTRING + "7.0%"));
			assertTrue(checkContent(MainApplication.MONTHLYAMOUNTSTRING + "30.78"));
			assertTrue(checkContent(MainApplication.TOTAAMOUNTSTRING + "1108.10"));

		} catch (IOException | ParseException e) {
			assertTrue("error should not have occurred: " + e.getMessage(), false);
		}
	}

	@Test
	public void testTotalAmount()
	{
		String[] args = {strPathOfInputFile, "2300"};
		try {
			MainApplication.main(args);
			assertTrue(checkContent(MainApplication.REQAMOUNTSTRING + "2300"));
			assertTrue(checkContent(MainApplication.RATESTRING + "7.5%"));
			assertTrue(checkContent(MainApplication.MONTHLYAMOUNTSTRING + "71.31"));
			assertTrue(checkContent(MainApplication.TOTAAMOUNTSTRING + "2567.23"));

		} catch (IOException | ParseException e) {
			assertTrue("error should not have occurred: " + e.getMessage(), false);
		}
	}


	@Test
	public void testApp()
	{
		String[] args = {strPathOfInputFile, "1700"};
		try {
			MainApplication.main(args);
			assertTrue(checkContent(MainApplication.REQAMOUNTSTRING + "1700"));
			assertTrue(checkContent(MainApplication.RATESTRING + "7.2%"));
			assertTrue(checkContent(MainApplication.MONTHLYAMOUNTSTRING + "52.46"));
			assertTrue(checkContent(MainApplication.TOTAAMOUNTSTRING + "1888.55"));

		} catch (IOException | ParseException e) {
			assertTrue("error should not have occurred: " + e.getMessage(), false);
		}
	}

	private boolean  checkContent(String toBeString) {
		return outContent.toString().contains(toBeString);
	}

}
