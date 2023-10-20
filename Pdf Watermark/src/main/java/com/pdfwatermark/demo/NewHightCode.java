package com.pdfwatermark.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class NewHightCode {
	public static void main(String[] args) {
		try {
			File pdfFile = new File(
					"C:\\Users\\User\\Downloads\\for learning\\For-Study-main\\Hibernate\\02 Hibernate Mapping Types With Example in Spring boot.pdf");
			PDDocument document = PDDocument.load(pdfFile);
		
			Map<Float, String> dataMap = new HashMap<>();
			List<String> values = new ArrayList<>();
			PDFTextStripper stripper = new PDFTextStripper() {
				@Override
				protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
					float lineHeight = 0;
					String newString = null;
					for (TextPosition textPosition : textPositions) {

						if (lineHeight < textPosition.getHeight()) {
							lineHeight = textPosition.getHeight();
							
							if (dataMap.containsKey(lineHeight)) {
								newString = newString + ", " + text;
								dataMap.put(lineHeight, newString);
							} else {
								newString = text;
								dataMap.put(lineHeight, text);
							}
						}
					}

//					System.out.println(" PDF Data : " + data);
//					System.out.println("Line: " + text + "\n - Height: " + lineHeight);
//					System.out.println("\n");
				}
			};

			stripper.setSortByPosition(true);
			stripper.setStartPage(1);
			stripper.setEndPage(1);
			String text = stripper.getText(document);
 
			for (Entry<Float, String> entry : dataMap.entrySet()) {
				System.out.println("Hight : " + entry.getKey() + " Text : " + entry.getValue());
			}
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
