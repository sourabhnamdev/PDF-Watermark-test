//package com.pdfwatermark.demo;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.TextPosition;
//
//public class TextHightInPDF {
//	public static void main(String[] args) {
//		try {
//			File pdfFile = new File("C:\\Users\\User\\Downloads\\your-pdf-file.pdf");
//			PDDocument document = PDDocument.load(pdfFile);
//
//			// Specify the page number you want to process (e.g., page 1)
//			int targetPage = 1;
//			PDPage page = document.getPage(targetPage - 1);
//
//			// Create a PDFTextStripper object to extract text
//			PDFTextStripper textStripper = new PDFTextStripper();
//
//			// Extract text from the specified page
////			String pdfText = textStripper.getText(document, page);
//
//			// Close the PDF document
//			document.close();
//
////			calculateLineHeight(pdfText);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void calculateLineHeight(String text) {
//		if (text == null || text.isEmpty()) {
//			return;
//		}
//
//		String[] lines = text.split("\n");
//
//		for (String line : lines) {
//			System.out.println("Line: " + line);
//			float lineHeight = getLineHeight(line);
//
//			System.out.println("Line Height: " + lineHeight + " points");
//		}
//	}
//
////	private static float getLineHeight(String line) {
////		float maxHeight = 0;
////
////		// Split the line into words
////		String[] words = line.split("\\s+");
////
////		for (String word : words) {
////			float wordHeight = getBoundingBoxHeightFromWord(word);
////			maxHeight = Math.max(maxHeight, wordHeight);
////		}
////
////		return maxHeight;
////	}
//
////	private static float getBoundingBoxHeightFromWord(String word) {
////		float wordHeight = 0;
////
////		try {
////			PDFTextStripper stripper = new PDFTextStripper();
////			// Extract text for the first page (no need to specify start and end pages)
//////			String pageText = stripper.getText();
////
////			// Iterate over text on the page
//////			for (String line : pageText.split("\n")) {
////				if (line.contains(word)) {
//////					List<TextPosition> wordPositions = stripper.getTextPositions();
////
////					for (TextPosition text : wordPositions) {
////						if (word.equals(text.getUnicode())) {
////							float height = text.getHeight();
////							if (height > wordHeight) {
////								wordHeight = height;
////							}
////						}
////					}
////				}
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////
////		return wordHeight;
////	}
//}
