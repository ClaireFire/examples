package com.yw.util;

public class Util {

	  public static String printCurrentMethod(){
	       StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
	       return traceElement.getMethodName();
	}
}
