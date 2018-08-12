package com.your.time.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String waitTime = "";
        try {
        	/*String targetDate = "2017/07/23 11:21:56";
            Date d1 = format.parse(targetDate);
            long diff = d1.getTime() - (new Date()).getTime();
            long days = Math.round(diff/1000/60/60/24);
            long reminder = diff>(1000*60*60*24)?diff % (1000*60*60*24):diff;
            long hours = reminder/1000/60/60;
            reminder = reminder>(1000 * 60 * 60)?reminder % (1000*60*60):reminder;
            long minutes = reminder/1000/60;
            reminder = reminder>(1000 * 60)?reminder % (1000*60):reminder;
            long seconds = reminder/1000;
            waitTime = days+"d,"+hours+"h,"+minutes+"m,"+seconds+"s";
            System.out.println("Waiting Time : "+waitTime);*/
        	
        	String targetDate = "2017/07/23 11:21:56";
            Date d1 = format.parse(targetDate);
            long diff = d1.getTime() - (new Date()).getTime();
            diff = diff < 0?0:diff;
            long days = Math.round(diff/1000/60/60/24);
            long reminder = diff % (1000*60*60*24);
            long hours = reminder/1000/60/60;
            reminder = reminder % (1000*60*60);
            long minutes = reminder/1000/60;
            reminder = reminder % (1000*60);
            long seconds = reminder/1000;
            waitTime = days+"d,"+hours+"h,"+minutes+"m,"+seconds+"s";
            System.out.println("Waiting Time : "+waitTime);        	
        	
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
