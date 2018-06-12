package com.suraj.jpaintegration.util;

public class CommonUtility {
	
	CommonUtility() {
	}
	
	public static String getSampleLogger(String strClassName, String strMethodName) {
		return "["+strClassName+"]" + "["+strMethodName+ "] - ";
	}

}
