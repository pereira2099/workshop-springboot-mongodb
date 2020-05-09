package com.example.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertDate(String textDate, Instant defaultValue) {		
		StringBuilder sb = new StringBuilder();
		sb.append(textDate);
		sb.append("T00:00:00Z");
		try {
			return Instant.parse(sb);
		}
		catch (DateTimeParseException e) {
			return defaultValue;
		}
	}
}
