package com.pdfwatermark.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFWaterMerkReader {

	public static void main(String[] args) {
		try {
			File pdfFile = new File("C:\\Users\\User\\Downloads\\watermark.pdf");// read
			// file
			// path
			FileInputStream inputStream = new FileInputStream(pdfFile); // read file

			PDDocument document = PDDocument.load(inputStream); // load data in document
			PDFTextStripper stripper = new PDFTextStripper(); // extract text

			int watermarkCount = 0;

			for (int i = 0; i < document.getNumberOfPages(); i++) {

				stripper.setStartPage(i + 1);
				stripper.setEndPage(i + 1);

				String pageText = stripper.getText(document);

				
				int countOnPage = countOccurrences(pageText, "PDF watermark");  //
				watermarkCount += countOnPage;

				if (countOnPage > 0) {
					System.out.println("\n Watermark Text on Page " + (i + 1) + ": " + countOnPage + " occurrences");
				}

//				System.out.println("Total watermarks found: " + watermarkCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int countOccurrences(String text, String target) {
		int count = 0;
		int lastIndex = 0;

		while ((lastIndex = text.indexOf(target, lastIndex)) != -1) {
			count++;
			lastIndex += target.length();
		}

		return count;
	}
}
