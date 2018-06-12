package com.suraj.jpaintegration.util;

public class CommonUtility {
	
	CommonUtility() {
	}
	
	public static String getSampleLogger(String strClassName, String strMethodName, String strMessage) {
		return "["+strClassName+"] " + "["+strMethodName+ "] - "+strMessage;
	}

}
