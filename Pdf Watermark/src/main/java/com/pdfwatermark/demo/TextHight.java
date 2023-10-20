//package com.pdfwatermark.demo;
//
// 
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.TextPosition;
//
//public class TextHight {
//
//	public static void main(String[] args) {
//		try {
//			File pdfFile = new File(
//					"C:\\Users\\User\\Downloads\\for learning\\For-Study-main\\Hibernate\\02 Hibernate Mapping Types With Example in Spring boot.pdf");
//			PDDocument document = PDDocument.load(pdfFile);
//
//			PDFTextStripper stripper = new () ;
//			
//			String text = stripper.getText(document);
//			Map<String, String> textWithUniqueKey = new HashMap<>();
//           List<List<TextPosition>> chars = stripper.getCh
////			document.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		}
//	}
//
//	