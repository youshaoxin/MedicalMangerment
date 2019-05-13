package com.itcast.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String getToday(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
}
