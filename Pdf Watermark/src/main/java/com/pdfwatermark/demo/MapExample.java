package com.pdfwatermark.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> dataMap = new HashMap<>();
		List<String> listOfString = new ArrayList<>();
		List<String> differentStrings = Arrays.asList("apple", "banana", "cherry","fittoo", "date", "elderberry");
		String newString =null;
		for (String string : differentStrings) {
			if (dataMap.containsKey(string.length())) {
				newString =newString +", " +string;
 				dataMap.put(string.length(), newString);
			}else {
				newString =string;
 				dataMap.put(string.length(), string);
			}
		}

		dataMap.entrySet().forEach(t -> {
			System.out.println(" Key : " + t.getKey() + " Values : " + t.getValue());
		});

	}
}
