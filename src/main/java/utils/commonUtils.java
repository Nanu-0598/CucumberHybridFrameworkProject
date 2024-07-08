package utils;

import java.util.Date;

public class commonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int PAGE_LOAD_TIME=10;
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "test"+date.toString().replace(" "," ")+"@gmail.com";
	}

}
