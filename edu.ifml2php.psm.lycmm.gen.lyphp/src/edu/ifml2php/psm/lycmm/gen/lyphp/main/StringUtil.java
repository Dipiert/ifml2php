package edu.ifml2php.psm.lycmm.gen.lyphp.main;

public class StringUtil {

	public String getSuffix(String str){
		char[] chars = str.toCharArray();
		for(int i = chars.length - 1; i > 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(i).toLowerCase();		
		return "";
	}
	
	public String getPrefix(String str){
		char[] chars = str.toCharArray();
		for(int i = chars.length - 1; i > 0; i--)
			if(chars[i] == Character.toUpperCase(chars[i]))
				return str.substring(0,i);		
		return "";
	}
	
	public String separatePrefixSuffix(String str){
		return getPrefix(str) + " " + getSuffix(str);
	}	
	
}