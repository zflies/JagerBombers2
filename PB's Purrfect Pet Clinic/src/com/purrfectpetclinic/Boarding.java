package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


public class Boarding {
	
	public static enum Options{
		bathgroom,
		addplaytime,
		dentalcleaning,
		lowfatfood;
	}
	
	public static enum Kennel{
		cat,
		smallDog,
		largeDog;
	}
	
	public static int MAXCATKENNELS = 6;
	public static int MAXSMALLDOGKENNELS = 4;
	public static int MAXLARGEDOGKENNELS = 4;
	
	final Date StartDate;
	final Date EndDate;
	final Pet BoardingPet;
	final Kennel BoardingKennel;
	final String Notes;
	
	Vector<Options> options = new Vector<Options>();
	
	public Boarding(Date start, Date end, Pet pet, Kennel kennel, String notes){
		StartDate = start;
		EndDate = end;
		BoardingPet = pet;
		BoardingKennel = kennel;
		Notes = notes;
	}
	
	public Boarding(Date start, Date end, Pet pet, Kennel kennel, String notes, Vector<Options> in_options){
		StartDate = start;
		EndDate = end;
		BoardingPet = pet;
		BoardingKennel = kennel;
		Notes = notes;
		options = in_options;
	}
	
	public void addOption(Options newOption){
		options.add(newOption);
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
	
	public Vector<Options> getOptions(){
		return this.options;
	}
	
	public String getKennelString(){
		switch(BoardingKennel){
		case cat: return "cat";
		case smallDog: return "smallDog";
		case largeDog: return "largeDog";
		default: return null;
		}
	}
	
	public String getNotes(){
		return this.Notes;
	}
	
	private String buildOptionsString(){
		int bathgroom = 0;
		int addplaytime = 0;
		int dentalcleaning = 0;
		int lowfatfood = 0;
		
		Vector<Options> options = this.getOptions();
		
		for(int i = 0; i < options.size(); i++){
			Options curOption = options.elementAt(i);
			if(curOption == Options.bathgroom)
				bathgroom = 1;
			else if(curOption == Options.addplaytime)
				addplaytime = 1;
			else if(curOption == Options.dentalcleaning)
				dentalcleaning = 1;
			else if(curOption == Options.lowfatfood)
				lowfatfood = 1;
		}
		
		String returnString = String.format("%d,  %d, %d, %d", bathgroom, addplaytime, dentalcleaning, lowfatfood);
		return returnString;
	}
	
	public void addToDB(int PetID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("INSERT INTO Boarding (PetID, StartDate, EndDate, Kennel, Options, Notes) VALUES (%d, '%s', '%s', '%s', '%s', '%s')"
				,PetID, new java.sql.Date(this.getStartDate().getTime()), new java.sql.Date(this.getEndDate().getTime()), this.getKennelString(), this.buildOptionsString(), this.getNotes());
		state.execute(commandstring);
		state.close();
	}
	
	private static Vector<Options> parseOptionsString(String options){
		Vector<Options> returnOptions =  new Vector<Options>();
		String[] optionsArray = options.split(",[ ]*");
		if(optionsArray[0].compareTo("1") == 0)
			returnOptions.add(Boarding.Options.bathgroom);
		if(optionsArray[1].compareTo("1") == 0)
			returnOptions.add(Boarding.Options.addplaytime);
		if(optionsArray[2].compareTo("1") == 0)
			returnOptions.add(Boarding.Options.dentalcleaning);
		if(optionsArray[3].compareTo("1") == 0)
			returnOptions.add(Boarding.Options.lowfatfood);
		
		return returnOptions;
	}
	
	public static boolean checkDateRange(Date start, Date end, Pet.Type type, Pet.Size size){
		//grab all boarding sessions
		Vector<Boarding> sessions = new Vector<Boarding>();
		try {
			sessions = getAllBoardingEntries();
		} catch (SQLException e) {
			System.out.println("Could not retrieve boarding sessions at this time");
			e.printStackTrace();
		}
		int check; //represents max number of kennels for specified type and size
		int count = 0; //represents current day's number of kennels taken
		Date curDate = start;
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		
		//add up total number of kennels taken for each date based on the pet type and size given
		
		//if a cat
		if(type == Pet.Type.cat)
			check = Boarding.MAXCATKENNELS;
		//if small dog
		else if(size == Pet.Size.small)
			check = Boarding.MAXSMALLDOGKENNELS;
		//if medium/large dog
		else
			check = Boarding.MAXLARGEDOGKENNELS;
		//if number is greater than or equal to max number (for any day) return false
		while(curDate.before(end)){
			curDate = c.getTime();
			count = 0;
			for(int i = 0; i < sessions.size(); i++){
				Boarding curSession = sessions.elementAt(i);
				Date startSession = curSession.getStartDate();
				Date endSession = curSession.getEndDate();
				//if current day exists in currently selected boarding session
				if(startSession.before(curDate) && endSession.after(curDate)){
					if(type == Pet.Type.cat){
						if(curSession.getPet().getPetType() == Pet.Type.cat)
							count++;
					}
					else if(size == Pet.Size.small){
						if(curSession.getPet().getPetSize() == Pet.Size.small)
							count++;
					}
					else{
						count++;
					}
				}
			}
			
			c.add(Calendar.DATE, 1);
			if(count >= check)
				return false;
		}
		//else return true
		return true;
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
			String Notes = rs.getString("Notes");
			//get options
			String OptionsString = rs.getString("Options");
			Vector<Options> options = parseOptionsString(OptionsString);
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel, Notes, options);
			AllBoarding.add(curBoard);
		}
		
		
		state.close();
		rs.close();
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
			String Notes = rs.getString("Notes");
			//get options
			String OptionsString = rs.getString("Options");
			Vector<Options> options = parseOptionsString(OptionsString);
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel, Notes, options);
						
			DayBoarding.add(curBoard);
		}
		state.close();
		rs.close();
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
		String sMonth = currDate.getMonth() + 1 + "";
		String sDay = "01";

		if ( sMonth.length() < 2 )
		{
			sMonth = "0" + sMonth;
		}

		String sStartDate = sYear + "-" + sMonth + "-" + sDay;
		
		if ( currDate.getMonth() >= 11 )
		{
			sYear = ( currDate.getYear() + 1901 ) + "";
			sMonth = "00";
		}
		else
		{
			sMonth = ( currDate.getMonth() + 2 ) + "";
			
			if ( sMonth.length() < 2 )
			{
				sMonth = "0" + sMonth;
			}
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
			String Notes = rs.getString("Notes");
			//get options
			String OptionsString = rs.getString("Options");
			Vector<Options> options = parseOptionsString(OptionsString);
			
			Pet curPet = Pet.getPetByID(PetID);
			Boarding curBoard = new Boarding(StartDate, EndDate, curPet, kennel, Notes, options);
						
			MonthBoarding.add(curBoard);
		}
		
		state.close();
		rs.close();
		return MonthBoarding;
	}
}
