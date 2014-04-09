package com.toedter.calendar.demo;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.IDateEvaluator;

public class BoardingDateEvaluator {

	private Calendar calendar = Calendar.getInstance();
	private Color darkGreen = new Color(0x007F00);
	private Color lightGreen = new Color(0xbbebc8);
	
	private String toolTip = "";

	/*public boolean isSpecial(Date date) {
		calendar.setTime(date);
		
		
		// TODO: Set the dates that have boarding
		
		return calendar.get(Calendar.MONTH) == Calendar.APRIL
		&& calendar.get(Calendar.DAY_OF_MONTH) == 8;
	}*/
	
	public String getPetsBoarding( Date date ) {
		
		calendar.setTime(date);
		//calendar.get(Calendar.MONTH)			//< Gets Month
		//calendar.get(Calendar.DAY_OF_MONTH)	//< Gets Day
		
		// TODO: Return pets boarding at special date
		
		if (calendar.get(Calendar.MONTH) == Calendar.APRIL
		&& calendar.get(Calendar.DAY_OF_MONTH) > 6 && calendar.get(Calendar.DAY_OF_MONTH) < 16)
		{
			toolTip = "Pooch is on low fat kibble";
			return "Pooch <br> Fluffy";
		}
		else
		{
			return "";
		}
	}
	
	public Color getSpecialForegroundColor() {
		return darkGreen;
	}

	public Color getSpecialBackroundColor() {
		return lightGreen;
	}

	public String getSpecialTooltip() {
		return toolTip;
	}

	public boolean isInvalid(Date date) {
		return false;
	}
	
	public Color getInvalidForegroundColor() {
		return null;
	}

	public Color getInvalidBackroundColor() {
		return null;
	}

	public String getInvalidTooltip() {
		return null;
	}

}
