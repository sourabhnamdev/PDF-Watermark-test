package com.pdfwatermark.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckEncryptedFile {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\User\\Downloads\\encrypted.html";

		if (isHTMLFile(filePath)) {
			System.out.println("---------its Valid File---------");

			try {
				String firstLine = readFirstLine(filePath);

				if (containsOnlySpaces(firstLine)) {
					System.out.println("Not Encrypted");
				} else {
					System.out.println("Encrypted");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("---------File is Not Valid---------");
		}
	}

	public static String readFirstLine(String filePath) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = reader.readLine();
			return line != null ? line : "";
		}
	}

	public static boolean containsOnlySpaces(String s) {
		return s.trim().isEmpty();
	}

	public static boolean isHTMLFile(String filePath) {
		return filePath.toLowerCase().endsWith(".html");
	}
}
