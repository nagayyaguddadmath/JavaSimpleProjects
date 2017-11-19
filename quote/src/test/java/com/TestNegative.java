package com;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

import com.MainApplication;
import com.service.InterestQuote;
import com.service.ReadMarkerFile;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class TestNegative 
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
	public void testWringInputFIle()
	{
		String[] args = {strPathOfInputFile+"Wrong", "1000"};
		try {
			MainApplication.main(args);
			assertTrue("Error should have occurred", false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue("Wrong file error should have occurred: " + e.getMessage(), e.getMessage().contains(ReadMarkerFile.WRONGFILEPATH));
		}
	}

	@Test
	public void testWrongArgument()
	{
		String[] args = {strPathOfInputFile};
		try {
			MainApplication.main(args);
			assertTrue("Error should have occurred", false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue("Wrong arguments error should have occurred: " + e.getMessage(), e.getMessage().contains(MainApplication.NOTVALIDARG));
		}
	}

	@Test
	public void testMoreThanLenders()
	{
		String[] args = {strPathOfInputFile, "10000"};
		try {
			MainApplication.main(args);
			assertTrue(InterestQuote.highAmountError, false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue(e.getMessage().contains(InterestQuote.highAmountError));
		}
	}

	@Test
	public void testHighLimit()
	{
		String[] args = {strPathOfInputFile, "100000"};
		try {
			MainApplication.main(args);
			assertTrue(InterestQuote.highAmountError, false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue("Wrong amount error should have occurred: " + e.getMessage(), e.getMessage().contains(MainApplication.NOTVALIDAMOUNT));
		}
	}

	@Test
	public void testLessAmount()
	{
		String[] args = {strPathOfInputFile, "500"};
		try {
			MainApplication.main(args);
			assertTrue(InterestQuote.highAmountError, false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue("Wrong amount error should have occurred: " + e.getMessage(), e.getMessage().contains(MainApplication.NOTVALIDAMOUNT));
		}
	}

	@Test
	public void testWrongAmount()
	{
		String[] args = {strPathOfInputFile, "2130"};
		try {
			MainApplication.main(args);
			assertTrue(InterestQuote.highAmountError, false);

		} catch (IOException | ParseException | IllegalArgumentException e) {
			assertTrue("Wrong amount error should have occurred: " + e.getMessage(), e.getMessage().contains(MainApplication.NOTVALIDAMOUNT));
		}
	}

}
