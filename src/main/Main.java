package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		long uts = now.getTime();
		System.out.println(uts);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowStr = sdf.format(now);
		System.out.println(nowStr);
		
		String initDate =  "2022-01-17";
		String finalDate = "2022-06-03";
		
		
		
		try {
			Date f1 = sdf.parse(initDate);
			Date f2 = sdf.parse(finalDate);
			
			if(now.getTime()>f1.getTime() && now.getTime()<f2.getTime()) {
				System.out.println("Está dentro de las fechas");
			}
			else {
				System.out.println("No está dentro de las fechas");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
