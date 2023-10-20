package com.pdfwatermark.demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class WaterMarkFinder {
	public static void main(String[] args) {
		try {
			File pdfFile = new File(
					"C:\\Users\\User\\Downloads\\for learning\\For-Study-main\\Hibernate\\02 Hibernate Mapping Types With Example in Spring boot.pdf");
			PDDocument document = PDDocument.load(pdfFile); // load doc.

			Map<String, Integer> watermarkCounts = new HashMap<>();

			for (int i = 0; i < document.getNumberOfPages(); i++) {
				PDFTextStripper stripper = new PDFTextStripper(); // using extract text
				stripper.setStartPage(i + 1);
				stripper.setEndPage(i + 1);
				String pageText = stripper.getText(document); // Get text for a specific page

				String[] lines = pageText.split("\n"); // split line

				// Analyze each line to find watermark names
				for (String line : lines) {
					if (!line.trim().isEmpty()) {
//	                        String[] words = line.trim().split("\\s+");
						watermarkCounts.put(line, watermarkCounts.getOrDefault(line, 0) + 1);

//	                        // Analyze each word in the line
//	                        for (String word : words) {
//	                            if (!word.trim().isEmpty()) {
//	                                String trimmedWord = word.trim();
//	                                
//	                                watermarkCounts.put(trimmedWord, watermarkCounts.getOrDefault(trimmedWord, 0) + 1);
//	                            }
//	                        }
					}
				}

				// Print watermark counts for the current page
				System.out.println("Page " + (i + 1));
				for (Map.Entry<String, Integer> entry : watermarkCounts.entrySet()) {
					System.out.println("Water Mark Occurrences : " + entry.getValue());
					System.out.println("Water Mark Name : " + entry.getKey());
				}
				watermarkCounts.clear(); // clear counts for the next page
			}

			document.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
