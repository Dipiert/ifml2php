package edu.ifml2php.psm.lycmm.gen.lyphp.services;

public class StringUtil {
	char[] chars;
	
	public String getSuffix(String str) {
		chars = str.toCharArray();
		for(int i = chars.length - 1; i >= 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(i);		
		return "";
	}
	
	public String getPrefix(String str) {
		chars = str.toCharArray();
		for(int i = chars.length - 1; i > 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(0,i);		
		return "";
	}
	
	public String separatePrefixSuffix(String str) {
		return getPrefix(str) + " " + getSuffix(str);
	}	
	
}
