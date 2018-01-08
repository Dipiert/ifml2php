package selenium.ifml2php;

public class Label {
	private static String year, title, audience;
	
	public Label() {
		year = "year";
		title = "title";
		audience = "audience";
	}

	public String getYear() {
		return year;
	}

	public String getTitle() {
		return title;
	}

	public static String getAudience() {
		return audience;
	}
	
	
}
