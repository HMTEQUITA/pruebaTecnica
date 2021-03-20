package com.mauricioTequita.libreriaApp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static final String FORMATO = "yyyy-MM-dd";
	
	
	public static String sumarDiasFecha(int dias) {
		
		Date fechaActual = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		
		return convertirDateString(calendar.getTime());
	}

	public static String convertirDateString(Date fecha){
	    SimpleDateFormat sf = new SimpleDateFormat(FORMATO);
	    return sf.format(fecha);
	}

	public static Date convertirStringDate(String fecha){
	    SimpleDateFormat sf = new SimpleDateFormat(FORMATO);
	    Date fechaDate = null;		
	    try {
	    	fechaDate = sf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return fechaDate;
	}
	
}
