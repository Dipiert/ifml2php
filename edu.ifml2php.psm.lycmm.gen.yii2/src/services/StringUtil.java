package services;

public class StringUtil {
	char[] chars;
	
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
	
	public String camelCase2CaterpillarCase(String camelCased) {
		camelCased.replace("([a-z])([A-Z])", "$1 $2");
		return camelCased.replace("\\s+|_+", "-").toLowerCase();		
	}
	
	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
}
