package edu.ifml2php.psm.lycmm.gen.laravel.services;

public class StringUtil {
	private char[] chars;
	
	public String getSuffix(String str) {
		chars = str.toCharArray();
		for(int i = chars.length - 1; i >= 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(i);		
		return str;
	}

	public String getPrefix(String str) {
		chars = str.toCharArray();
		for(int i = chars.length - 1; i > 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(0,i);		
		return str;
	}

	public String separatePrefixSuffix(String str) {
		return getPrefix(str) + " " + getSuffix(str);
	}	

	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
}
