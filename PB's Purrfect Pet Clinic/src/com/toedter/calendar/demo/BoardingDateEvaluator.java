package com.toedter.calendar.demo;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import com.purrfectpetclinic.Boarding;
import com.purrfectpetclinic.Pet;
import com.purrfectpetclinic.Boarding.Options;

public class BoardingDateEvaluator {

	private Color darkGreen = new Color(0x007F00);
	private Color lightGreen = new Color(0xbbebc8);
	
	private String toolTip = "";
	
	@SuppressWarnings("deprecation")
	public String getPetsBoarding( Date date, Vector<Boarding> monthBoarding ) throws SQLException {
		
			toolTip = "";					// Can be changed to include notes for the pets
			
			String sPets = "";
			String sPetName = "";
			Vector<Options> options = new Vector<Options>();
			String sOptions = "";
			String sNotes = "";
			Pet pet = null;
			
			/* Get the pets that are being boarded on the given date */
			for (int i = 0; i < monthBoarding.size(); i++ )
			{
				Boarding currBoarding = monthBoarding.get( i );

				if( date.compareTo( currBoarding.getEndDate() ) <= 0 && currBoarding.getStartDate().compareTo( date ) <= 0 )
				{
					pet = monthBoarding.get( i ).getPet();
					sPetName = pet.getName();
					options = currBoarding.getOptions();
										
					for (int j = 0; j < options.size(); j++)
					{
						Options curOption = options.elementAt(j);
						if(curOption == Options.bathgroom)
							sOptions += "Bathing/Grooming; ";
						else if(curOption == Options.addplaytime)
							sOptions += "Additional Play Time; ";
						else if(curOption == Options.dentalcleaning)
							sOptions += "Dental Cleaning; ";
						else if(curOption == Options.lowfatfood)
							sOptions += "Low Fat Food; ";
					}
					
					sNotes = currBoarding.getNotes();
					if ( sOptions != "" )
					{
						if ( sNotes.compareTo("Notes") != 0 )
						{
							toolTip += sPetName + " -- " + sOptions + " (" + sNotes + ")" +"<br><br>"; 
						}
						else
						{
							toolTip += sPetName + " -- " + sOptions + "<br><br>"; 
						}
					}
					else
					{
						if ( sNotes.compareTo("Notes") != 0 )
						{
							toolTip += sPetName + " -- " + sOptions + " (" + sNotes + ")" +"<br><br>"; 
						}
					}
					
					sPets += "<br>" + sPetName;
					
					
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
