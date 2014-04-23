package com.toedter.calendar.demo;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import com.purrfectpetclinic.Boarding;

public class BoardingDateEvaluator {

	private Color darkGreen = new Color(0x007F00);
	private Color lightGreen = new Color(0xbbebc8);
	
	private String toolTip = "";
	
	@SuppressWarnings("deprecation")
	public String getPetsBoarding( Date date, Vector<Boarding> monthBoarding ) throws SQLException {
		
			toolTip = null;					// Can be changed to include notes for the pets
			
			String sPets = "";
			
			/* Get the pets that are being boarded on the given date */
			for (int i = 0; i < monthBoarding.size(); i++ )
			{
				Boarding currBoarding = monthBoarding.get( i );

				if ( date.getDate() <= currBoarding.getEndDate().getDate() && date.getDate() >= currBoarding.getStartDate().getDate() )
				{
					sPets += "<br>" + monthBoarding.get( i ).getPet().getName();
				}
			}
			
			return sPets;
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
