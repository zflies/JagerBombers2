package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;


public class Boarding {
	
	public static enum Kennel{
		cat1,
		cat2,
		cat3,
		cat4,
		cat5,
		cat6,
		smallDog1,
		smallDog2,
		smallDog3,
		smallDog4,
		largeDog1,
		largeDog2,
		largeDog3,
		largeDog4;
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
		case cat1: return "Cat1";
		case cat2: return "Cat2";
		case cat3: return "Cat3";
		case cat4: return "Cat4";
		case cat5: return "Cat5";
		case cat6: return "Cat6";
		case smallDog1: return "SmallDog1";
		case smallDog2: return "SmallDog2";
		case smallDog3: return "SmallDog3"; 
		case smallDog4: return "SmallDog4";
		case largeDog1: return "LargeDog1";
		case largeDog2: return "LargeDog2";
		case largeDog3: return "LargeDog3";
		case largeDog4: return "LargeDog4";
		default: return null;
		}
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
			if(KennelString.compareTo("cat1") == 0)
				kennel = Kennel.cat1;
			else if(KennelString.compareTo("cat2") == 0)
				kennel = Kennel.cat2;
			else if(KennelString.compareTo("cat3") == 0)
				kennel = Kennel.cat3;
			else if(KennelString.compareTo("cat4") == 0)
				kennel = Kennel.cat4;
			else if(KennelString.compareTo("cat5") == 0)
				kennel = Kennel.cat5;
			else if(KennelString.compareTo("cat6") == 0)
				kennel = Kennel.cat6;
			else if(KennelString.compareTo("smallDog1") == 0)
				kennel = Kennel.smallDog1;
			else if(KennelString.compareTo("smallDog2") == 0)
				kennel = Kennel.smallDog2;
			else if(KennelString.compareTo("smallDog3") == 0)
				kennel = Kennel.smallDog3;
			else if(KennelString.compareTo("smallDog4") == 0)
				kennel = Kennel.smallDog4;
			else if(KennelString.compareTo("largeDog1") == 0)
				kennel = Kennel.largeDog1;
			else if(KennelString.compareTo("largeDog2") == 0)
				kennel = Kennel.largeDog2;
			else if(KennelString.compareTo("largeDog3") == 0)
				kennel = Kennel.largeDog3;
			else
				kennel = Kennel.largeDog4;
			
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
			if(KennelString.compareTo("cat1") == 0)
				kennel = Kennel.cat1;
			else if(KennelString.compareTo("cat2") == 0)
				kennel = Kennel.cat2;
			else if(KennelString.compareTo("cat3") == 0)
				kennel = Kennel.cat3;
			else if(KennelString.compareTo("cat4") == 0)
				kennel = Kennel.cat4;
			else if(KennelString.compareTo("cat5") == 0)
				kennel = Kennel.cat5;
			else if(KennelString.compareTo("cat6") == 0)
				kennel = Kennel.cat6;
			else if(KennelString.compareTo("smallDog1") == 0)
				kennel = Kennel.smallDog1;
			else if(KennelString.compareTo("smallDog2") == 0)
				kennel = Kennel.smallDog2;
			else if(KennelString.compareTo("smallDog3") == 0)
				kennel = Kennel.smallDog3;
			else if(KennelString.compareTo("smallDog4") == 0)
				kennel = Kennel.smallDog4;
			else if(KennelString.compareTo("largeDog1") == 0)
				kennel = Kennel.largeDog1;
			else if(KennelString.compareTo("largeDog2") == 0)
				kennel = Kennel.largeDog2;
			else if(KennelString.compareTo("largeDog3") == 0)
				kennel = Kennel.largeDog3;
			else
				kennel = Kennel.largeDog4;
			
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
			if(KennelString.compareTo("cat1") == 0)
				kennel = Kennel.cat1;
			else if(KennelString.compareTo("cat2") == 0)
				kennel = Kennel.cat2;
			else if(KennelString.compareTo("cat3") == 0)
				kennel = Kennel.cat3;
			else if(KennelString.compareTo("cat4") == 0)
				kennel = Kennel.cat4;
			else if(KennelString.compareTo("cat5") == 0)
				kennel = Kennel.cat5;
			else if(KennelString.compareTo("cat6") == 0)
				kennel = Kennel.cat6;
			else if(KennelString.compareTo("smallDog1") == 0)
				kennel = Kennel.smallDog1;
			else if(KennelString.compareTo("smallDog2") == 0)
				kennel = Kennel.smallDog2;
			else if(KennelString.compareTo("smallDog3") == 0)
				kennel = Kennel.smallDog3;
			else if(KennelString.compareTo("smallDog4") == 0)
				kennel = Kennel.smallDog4;
			else if(KennelString.compareTo("largeDog1") == 0)
				kennel = Kennel.largeDog1;
			else if(KennelString.compareTo("largeDog2") == 0)
				kennel = Kennel.largeDog2;
			else if(KennelString.compareTo("largeDog3") == 0)
				kennel = Kennel.largeDog3;
			else
				kennel = Kennel.largeDog4;
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel);
						
			MonthBoarding.add(curBoard);
		}
		
		state.close();
		return MonthBoarding;
	}
}
