package com.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.model.Lender;

/*
 * Reads Given file and returns the Lender list
 */
public class ReadMarkerFile {
	
	public final static String WRONGFILEPATH = "Error occurred while reading market file: ";

	public Set<Lender> readLenderFromFile(String filePath) throws IOException, ParseException {
		Set<Lender> lenders = new TreeSet<Lender>();
		File file = new File(filePath);
		try (
				Scanner scanner = new Scanner(file)
				) {
			scanner.nextLine();
			while(scanner.hasNextLine()){
				lenders.add(new Lender(scanner.nextLine()));
			}

		} catch (FileNotFoundException ex) {
			System.out.println(WRONGFILEPATH + ex.getMessage());
			throw new IllegalArgumentException(WRONGFILEPATH + ex.getMessage());
		} 

		return lenders;
	}

}
