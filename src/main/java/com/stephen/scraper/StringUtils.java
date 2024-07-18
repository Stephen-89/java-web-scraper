package com.stephen.scraper;

public class StringUtils {

	public static String extractGrade(String name) {
		int startIndex = name.indexOf('(') + 1;
        int endIndex = name.indexOf(' ', startIndex);
        return name.substring(startIndex, endIndex);
	}
	
	public static String removeBeforeFirstSpace(String input) {
        int firstSpaceIndex = input.indexOf(' ');
        if (firstSpaceIndex != -1) {
            return input.substring(firstSpaceIndex + 1);
        } else {
            return input;
        }
    }
	
	public static String[] splitString(String name){
		String[] parts = name.split("\\(");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace(")", "").trim();
        }
		return parts;
	}
	
}
