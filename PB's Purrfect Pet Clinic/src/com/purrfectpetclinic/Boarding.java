package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;


public class Boarding {
	//TODO: Add options to class
	
	public static enum Kennel{
		cat,
		smallDog,
		largeDog;
	}
	
	final Date StartDate;
	final Date EndDate;
	final Pet BoardingPet;
	final Kennel BoardingKennel;
	
	public Boarding(Date start, Date end, Pet pet, Kennel kennel){
		StartDate = start;
		EndDate = end;
		BoardingPet = pet;
		BoardingKennel = kennel;
	}
	
	public Pet getPet(){
		return BoardingPet;
	}
	
	public Date getStartDate(){
		return StartDate;
	}
	
	public Date getEndDate(){
		return EndDate;
	}
	
	public Kennel getKennel(){
		return BoardingKennel;
	}
	
	public String getKennelString(){
		switch(BoardingKennel){
		case cat: return "Cat";
		case smallDog: return "SmallDog";
		case largeDog: return "LargeDog";
		default: return null;
		}
	}
	
	//TODO: This function
	public static boolean checkDateRange(Date start, Date end, Pet.Type type, Pet.Size size){
		//grab all boarding sessions between date range given
		//add up total number of kennels taken for each date based on the pet type and size given
		//if number is greater than or equal to max number (for any day) return false
		//else return true
		return true;
	}
	
	//TODO: This function
	public static Vector<Boarding> getBoardingSessionsDateRange(Date start, Date end){
		Vector<Boarding> Sessions = new Vector<Boarding>();
		//get all boarding sessions in this date range
		
		
		return Sessions;
	}
	
	/**
	 * Returns all boarding entries in the DB
	 * @return
	 * @throws SQLException
	 */
	public static Vector<Boarding> getAllBoardingEntries() throws SQLException{
		Vector<Boarding> AllBoarding = new Vector<Boarding>();
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT * FROM Boarding");
		ResultSet rs = state.executeQuery(commandstring);
		while(rs.next()){
			int PetID = rs.getInt("PetID");
			Date StartDate = new Date(rs.getDate("StartDate").getTime());
			Date EndDate = new Date(rs.getDate("EndDate").getTime());
			String KennelString = rs.getString("Kennel");
			Kennel kennel;
			if(KennelString.compareTo("cat") == 0)
				kennel = Kennel.cat;
			else if(KennelString.compareTo("smallDog") == 0)
				kennel = Kennel.smallDog;
			else 
				kennel = Kennel.largeDog;
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel);
			AllBoarding.add(curBoard);
		}
		
		
		state.close();
		return AllBoarding;
	}
	
	
	/**
	 * Returns the boarding sessions for a specific day
	 * @param currDate
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static Vector<Boarding> getDayBoarding( Date currDate ) throws SQLException{
		
		Vector<Boarding> DayBoarding = new Vector<Boarding>();
		
		String sYear = (currDate.getYear() + 1900) + "";
		String sMonth = currDate.getMonth() + "";
		String sDay = currDate.getDate() + "";

		if ( sMonth.length() < 2 )
		{
			sMonth = "0" + sMonth;
		}

		if ( sDay.length() < 2 )
		{
			sDay = "0" + sDay;
		}

		String sCurrDate = sYear + "-" + sMonth + "-" + sDay;
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT * FROM Boarding WHERE StartDate <= STR_TO_DATE('" + sCurrDate + "', '%Y-%m-%d') AND EndDate >= STR_TO_DATE('" + sCurrDate + "', '%Y-%m-%d');";
		ResultSet rs = state.executeQuery(commandstring);
		while(rs.next()){
			int PetID = rs.getInt("PetID");
			Date StartDate = new Date(rs.getDate("StartDate").getTime());
			Date EndDate = new Date(rs.getDate("EndDate").getTime());
			String KennelString = rs.getString("Kennel");
			Kennel kennel;
			if(KennelString.compareTo("cat") == 0)
				kennel = Kennel.cat;
			else if(KennelString.compareTo("smallDog") == 0)
				kennel = Kennel.smallDog;
			else 
				kennel = Kennel.largeDog;
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel);
						
			DayBoarding.add(curBoard);
		}
		
		
		state.close();
		return DayBoarding;
	}
	
	
	/**
	 * Returns the boarding sessions for an entire month
	 * @param currDate
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static Vector<Boarding> getMonthBoarding( Date currDate ) throws SQLException{
		
		Vector<Boarding> MonthBoarding = new Vector<Boarding>();
		
		String sYear = (currDate.getYear() + 1900) + "";
		String sMonth = currDate.getMonth() + "";
		String sDay = "01";

		if ( sMonth.length() < 2 )
		{
			sMonth = "0" + sMonth;
		}

		String sStartDate = sYear + "-" + sMonth + "-" + sDay;
		
		if ( currDate.getMonth() == 11 )
		{
			sYear = ( currDate.getYear() + 1901 ) + "";
			sMonth = "00";
		}
		else
		{
			sMonth = ( currDate.getMonth() + 1 ) + "";
		}
		
		String sEndDate = sYear + "-" + sMonth + "-" + sDay;
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT * FROM Boarding WHERE StartDate >= STR_TO_DATE('" + sStartDate + "', '%Y-%m-%d') AND EndDate < STR_TO_DATE('" + sEndDate + "', '%Y-%m-%d') ORDER BY StartDate;";
		ResultSet rs = state.executeQuery(commandstring);
		while(rs.next()){
			int PetID = rs.getInt("PetID");
			Date StartDate = new Date(rs.getDate("StartDate").getTime());
			Date EndDate = new Date(rs.getDate("EndDate").getTime());
			String KennelString = rs.getString("Kennel");
			Kennel kennel;
			if(KennelString.compareTo("cat") == 0)
				kennel = Kennel.cat;
			else if(KennelString.compareTo("smallDog") == 0)
				kennel = Kennel.smallDog;
			else 
				kennel = Kennel.largeDog;
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel);
						
			MonthBoarding.add(curBoard);
		}
		
		state.close();
		return MonthBoarding;
	}
}
