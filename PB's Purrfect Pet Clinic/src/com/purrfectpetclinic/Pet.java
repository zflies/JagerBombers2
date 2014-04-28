package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class Pet {
	public static enum Type{
		cat,
		dog;
	}
	
	public static enum Sex{
		male,
		female;
	}
	
	public static enum Size{
		small,
		medium,
		large;
	}
	
	final Type PetType;
	final String Name;
	final String OwnerName;
	final Sex PetSex;
	final Size PetSize;
	final String Color;
	final Date DateOfBirth;
	final String Prescriptions;
	final Double Weight;
	final String Breed;
	final String Notes;
	public List<Reminder> Reminders = new ArrayList<Reminder>();
	
	Vector<Immunization> Immunizations = new Vector<Immunization>();
	
	public Pet(Type type, String name, String owner, Sex sex, Size size, String color, Date dob, String prescriptions, Double weight, String breed, String notes){
		if(type == Type.cat){
			this.PetType = Type.cat;
			this.PetSize = Size.small;
		}
		else{
			this.PetType = Type.dog;
			this.PetSize = size;
		}
		this.Name = name;
		this.OwnerName = owner;
		this.PetSex = sex;
		this.Color = color;
		this.DateOfBirth = dob;
		this.Prescriptions = prescriptions;
		this.Weight = weight;
		this.Breed = breed;
		this.Notes = notes;
	}
	
	public static Type createType(String type){
		if(type.compareTo("Cat") == 0)
			return Type.cat;
		else
			return Type.dog;
		
	}
	
	public static Size createSize(String size){
		if(size.compareTo("Small") == 0)
			return Size.small;
		else if(size.compareTo("Medium") == 0)
			return Size.medium;
		else
			return Size.large;
	}
	
	public boolean checkImmunizations(){
		Date curDate = new Date();
		boolean Rabies = false;
		boolean Distemper = false;
		boolean Bordatella = false;
		
		if(Immunizations.size() != 3)
			return false;
		for(int i = 0; i < Immunizations.size(); i++){
			Immunization curImmune = Immunizations.elementAt(i);
			if(curImmune.getImmunizationType() == Immunization.ImmunizationType.Rabies)
				Rabies = true;
			else if(curImmune.getImmunizationType() == Immunization.ImmunizationType.Distemper)
				Distemper = true;
			else if(curImmune.getImmunizationType() == Immunization.ImmunizationType.Bordatella)
				Bordatella = true;
		}
		if(!(Rabies && Distemper && Bordatella))
			return false;
		
		for(int i = 0; i < Immunizations.size(); i++){
			Immunization curImmune = Immunizations.elementAt(i);
			if(curImmune.getEndDate().after(curDate))
				continue;
			else
				return false;
		}
		return true;
	}
	
	public static Pet getPetByID(int PetID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT * FROM Pets WHERE ID = %d", PetID);
		ResultSet rs = state.executeQuery(commandstring);
		
		rs.next();
		String PetTypeString = rs.getString("Type");
		Pet.Type PetType;
		if(PetTypeString.compareTo("dog") == 0)
			PetType = Pet.Type.dog;
		else
			PetType = Pet.Type.cat;
		
		String Name = rs.getString("Name");
		//get owner name from DB
		Statement state3 = DBConnection.OpenConnection();
		commandstring = String.format("SELECT FirstName, LastName FROM Owner WHERE ID = %d", rs.getInt("Owner_ID"));
		ResultSet rs3 = state3.executeQuery(commandstring);
		rs3.next();
		String OwnerName = rs3.getString("FirstName") + rs3.getString("LastName");
		
		String PetSexString = rs.getString("Sex");
		Pet.Sex PetSex;
		if(PetSexString.compareTo("male") == 0)
			PetSex = Pet.Sex.male;
		else
			PetSex = Pet.Sex.female;
		
		String PetSizeString = rs.getString("Size");
		Pet.Size PetSize;
		if(PetSizeString.compareTo("small") == 0)
			PetSize = Pet.Size.small;
		else if(PetSizeString.compareTo("medium") == 0)
			PetSize = Pet.Size.medium;
		else
			PetSize = Pet.Size.large;
		
		String Color = rs.getString("Color");
		java.sql.Date DbDate = rs.getDate("DOB");
		Date DateOfBirth = new Date(DbDate.getTime());
		
		String Prescriptions = rs.getString("Prescriptions");
		Double Weight = rs.getDouble("Weight");
		String Breed = rs.getString("Breed");
		String Notes = rs.getString("Notes");
		
		//create new pet object from DB info and add to the owners list of pets
		Pet newPet = new Pet(PetType, Name, OwnerName, PetSex, PetSize, Color, DateOfBirth, Prescriptions, Weight, Breed, Notes);
		
		//get Immunizations of pet
		Statement state2 = DBConnection.OpenConnection();
		commandstring = String.format("SELECT * FROM Immunizations WHERE Pet_ID = %d", PetID);
		ResultSet rs2 = state2.executeQuery(commandstring);
		while(rs2.next()){
			Date StartDate = new Date(rs2.getDate("Start_Date").getTime());
			Date EndDate = new Date(rs2.getDate("End_Date").getTime());
			String ImmuneName = rs2.getString("Immunization");
			
			if(ImmuneName.compareTo("Rabies") == 0){
				Immunization i = new Immunization(Immunization.ImmunizationType.Rabies, StartDate, EndDate);
				newPet.addImmunization(i);
			}
			else if(ImmuneName.compareTo("Distemper") == 0){
				Immunization i = new Immunization(Immunization.ImmunizationType.Distemper, StartDate, EndDate);
				newPet.addImmunization(i);
			}
			else{
				Immunization i = new Immunization(Immunization.ImmunizationType.Bordatella, StartDate, EndDate);
				newPet.addImmunization(i);
			}
		}
		
		state.close();
		state2.close();
		state3.close();
		return newPet;
	}
	
	public static Pet getPetByID(int PetID, String ownerName) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT * FROM Pets WHERE ID = %d", PetID);
		ResultSet rs = state.executeQuery(commandstring);
		
		rs.next();
		String PetTypeString = rs.getString("Type");
		Pet.Type PetType;
		if(PetTypeString.compareTo("dog") == 0)
			PetType = Pet.Type.dog;
		else
			PetType = Pet.Type.cat;
		
		String Name = rs.getString("Name");
		String OwnerName = ownerName;
		String PetSexString = rs.getString("Sex");
		Pet.Sex PetSex;
		if(PetSexString.compareTo("male") == 0)
			PetSex = Pet.Sex.male;
		else
			PetSex = Pet.Sex.female;
		
		String PetSizeString = rs.getString("Size");
		Pet.Size PetSize;
		if(PetSizeString.compareTo("small") == 0)
			PetSize = Pet.Size.small;
		else if(PetSizeString.compareTo("medium") == 0)
			PetSize = Pet.Size.medium;
		else
			PetSize = Pet.Size.large;
		
		String Color = rs.getString("Color");
		java.sql.Date DbDate = rs.getDate("DOB");
		Date DateOfBirth = new Date(DbDate.getTime());
		
		String Prescriptions = rs.getString("Prescriptions");
		Double Weight = rs.getDouble("Weight");
		String Breed = rs.getString("Breed");
		String Notes = rs.getString("Notes");
		
		//create new pet object from DB info and add to the owners list of pets
		Pet newPet = new Pet(PetType, Name, OwnerName, PetSex, PetSize, Color, DateOfBirth, Prescriptions, Weight, Breed, Notes);
		
		//get Immunizations of pet
		Statement state2 = DBConnection.OpenConnection();
		commandstring = String.format("SELECT * FROM Immunizations WHERE Pet_ID = %d", PetID);
		ResultSet rs2 = state2.executeQuery(commandstring);
		while(rs2.next()){
			Date StartDate = new Date(rs2.getDate("Start_Date").getTime());
			Date EndDate = new Date(rs2.getDate("End_Date").getTime());
			String ImmuneName = rs2.getString("Immunization");
			
			if(ImmuneName.compareTo("Rabies") == 0){
				Immunization i = new Immunization(Immunization.ImmunizationType.Rabies, StartDate, EndDate);
				newPet.addImmunization(i);
			}
			else if(ImmuneName.compareTo("Distemper") == 0){
				Immunization i = new Immunization(Immunization.ImmunizationType.Distemper, StartDate, EndDate);
				newPet.addImmunization(i);
			}
			else{
				Immunization i = new Immunization(Immunization.ImmunizationType.Bordatella, StartDate, EndDate);
				newPet.addImmunization(i);
			}
		}
		
		state.close();
		state2.close();
		return newPet;
	}
	
	public void createImmunization(Immunization.ImmunizationType type, int petID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring;
		if(type == Immunization.ImmunizationType.Rabies){
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 3);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("INSERT INTO Immunizations VALUES(%d, '%s', '%s', '%s')", petID, "Rabies", StartDateSQL, EndDateSQL);
		}
		else if(type == Immunization.ImmunizationType.Distemper){
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 3);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("INSERT INTO Immunizations VALUES(%d, '%s', '%s', '%s')", petID, "Distemper", StartDateSQL, EndDateSQL);
		}
		else{
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 1);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("INSERT INTO Immunizations VALUES(%d, '%s', '%s', '%s')", petID, "Bordatella", StartDateSQL, EndDateSQL);
		}
		state.execute(commandstring);
		state.close();
	}
	
	public void updateImmunization(Immunization.ImmunizationType type, int petID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring;
		if(type == Immunization.ImmunizationType.Rabies){
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 3);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("UPDATE Immunizations SET Start_Date = '%s', End_Date = '%s' WHERE Pet_ID = %d AND Immunization = 'Rabies'", StartDateSQL, EndDateSQL, petID);
		}
		else if(type == Immunization.ImmunizationType.Distemper){
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 3);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("UPDATE Immunizations SET Start_Date = '%s', End_Date = '%s' WHERE Pet_ID = %d AND Immunization = 'Distemper'", StartDateSQL, EndDateSQL, petID);
		}
		else{
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.add(Calendar.YEAR, 1);
			Date StartDate = new Date();
			Date EndDate = newCalendar.getTime();
			java.sql.Date StartDateSQL = new java.sql.Date(StartDate.getTime());
			java.sql.Date EndDateSQL = new java.sql.Date(EndDate.getTime());
			commandstring = String.format("UPDATE Immunizations SET Start_Date = '%s', End_Date = '%s' WHERE Pet_ID = %d AND Immunization = 'Bordatella'", StartDateSQL, EndDateSQL, petID);
		}
		state.execute(commandstring);
		state.close();
	}
	
	public void addImmunization(Immunization newImmune){
		Immunizations.add(newImmune);
	}
	
	public Date getImmunizationStartDate(Immunization.ImmunizationType type){
		for(int i = 0; i < Immunizations.size(); i++){
			Immunization j = Immunizations.elementAt(i);
			if(j.getImmunizationType() == type){
				return j.getStartDate();
			}
		}
		return null;
	}
	
	public Date getImmunizationEndDate(Immunization.ImmunizationType type){
		for(int i = 0; i < Immunizations.size(); i++){
			Immunization j = Immunizations.elementAt(i);
			if(j.getImmunizationType() == type){
				return j.getEndDate();
			}
		}
		return null;
	}
	
	public String getTypeString(){
		if(this.PetType == Type.cat)
			return "Cat";
		else
			return "Dog";
	}
	
	public Type getPetType(){
		return this.PetType;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public String getName( int Pet_ID ) throws SQLException{
		
		String name = "";
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT Name FROM pets WHERE ID = '%s'", Pet_ID);
		
		if ( state != null )
		{
			ResultSet rs = state.executeQuery(commandstring);
			while(rs.next()) 
			{
				name = rs.getString("Name");
			}
			state.close();
		}

		
		return name;
	}
	
	public String getOwnerName(){
		return this.OwnerName;
	}
	
	public String getPetSexString(){
		if(this.PetSex == Sex.female)
			return "Female";
		else
			return "Male";
	}
	
	public Sex getPetSex(){
		return this.PetSex;
	}
	
	public String getPetSizeString(){
		if(this.PetSize == Size.small)
			return "Small";
		else if(this.PetSize == Size.medium)
			return "Medium";
		else
			return "Large";
	}
	
	public Size getPetSize(){
		return this.PetSize;
	}
	
	public String getColor(){
		return this.Color;
	}
	
	public Date getDOB(){
		return this.DateOfBirth;
	}
	
	public String getPrescriptions(){
		return this.Prescriptions;
	}
	
	public Double getWeight(){
		return this.Weight;
	}
	
	public String getBreed(){
		return this.Breed;
	}
	
	public String getNotes(){
		return this.Notes;
	}
	
	public void addPetDB() throws SQLException{
		//add this Pet to the DB
		String Name = this.getName();
		String Size = this.getPetSizeString();
		String Sex = this.getPetSexString();
		String Breed = this.getBreed();
		String Type = this.getTypeString();
		String Color = this.getColor();
		java.sql.Date DOB = new java.sql.Date(this.getDOB().getTime());
		String Prescriptions = this.getPrescriptions();
		String Notes = this.getNotes();
		String Weight = String.valueOf(this.getWeight());
		
		Statement state = DBConnection.OpenConnection();
		//grab owners ID
		String OwnerFirstName = this.OwnerName.substring(0, this.OwnerName.indexOf(" "));
		String OwnerLastName = this.OwnerName.substring(this.OwnerName.indexOf(" ") + 1);
		String commandstring = String.format("SELECT ID FROM Owner WHERE FirstName = '%s' AND LastName = '%s'", OwnerFirstName, OwnerLastName);
		ResultSet rs = state.executeQuery(commandstring);
		String OwnerID = "";
		if(rs.next())
			OwnerID = rs.getString("ID");
		
		//insert pet to DB
		commandstring = String.format("INSERT INTO pets "
				+ "(Name, Size, Sex, Breed, Type, Color, DOB, Owner_ID, Prescriptions, Notes, Weight) "
				+ "VALUES ('%s', '%s', '%s', '%s' , '%s', '%s', '%s', %s, '%s', '%s', %s);",
				Name, Size, Sex, Breed, Type, Color, DOB, OwnerID, Prescriptions, Notes, Weight);
		
		state.execute(commandstring);
		state.close();
	}
	
	public int getID(int OwnerID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT ID FROM pets WHERE Name = '%s' AND Owner_ID = %d", Name, OwnerID);
		ResultSet rs = state.executeQuery(commandstring);
		rs.next();
		int ID = rs.getInt("ID");
		state.close();
		return ID;
	}
	
	public void deletePet(int OwnerID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("DELETE FROM pets WHERE Name = '%s' AND Type = '%s' AND Owner_ID = %d", Name, getTypeString(), OwnerID);
		state.execute(commandstring);
		state.close();
	}
	
	public void replacePet(int PetID) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("UPDATE pets "
				+ "SET Name = '%s', Size = '%s', Breed = '%s', Type = '%s', Color = '%s', DOB = '%s', Prescriptions = '%s', Notes = '%s', Weight = %f  "
				+ "WHERE ID = %d", Name, getPetSizeString(), Breed, getTypeString(), Color, new java.sql.Date(this.getDOB().getTime()), Prescriptions, Notes, Weight, PetID);
		state.execute(commandstring);
		state.close();
	}

	public void updateReminders (int PetID, List<String> immunizationReminder, List<String> wellnessReminder, List<String> labReminder) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = "";
		String immunizationMethods = "";
		String wellnessMethods = "";
		String labMethods = "";
		String immunizationFrequency = immunizationReminder.get(immunizationReminder.size()-1);
		String wellnessFrequency = wellnessReminder.get(wellnessReminder.size()-1);
		String labFrequency = labReminder.get(labReminder.size()-1);
		
		if(!immunizationReminder.isEmpty()){
			for(int i = 0; i < immunizationReminder.size()-1; i++){
				if(immunizationMethods.compareTo("") == 0){
					immunizationMethods = immunizationReminder.get(i);
				}
				else{
					immunizationMethods = immunizationMethods + "," + immunizationReminder.get(i);
				}
			}
		}
		if(!wellnessReminder.isEmpty()){
			for(int i = 0; i < wellnessReminder.size()-1; i++){
				if(wellnessMethods.compareTo("") == 0){
					wellnessMethods = wellnessReminder.get(i);
				}
				else{
					wellnessMethods = wellnessMethods + "," + wellnessReminder.get(i);
				}
			}
		}
		if(!labReminder.isEmpty()){
			for(int i = 0; i < labReminder.size()-1; i++){
				if(labMethods.compareTo("") == 0){
					labMethods = labReminder.get(i);
				}
				else{
					labMethods = labMethods + "," + labReminder.get(i);
				}
			}
		}
		//INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('1', 'immunization,lab work', 'email,text', 'oneWeek');
		/*
		 * UPDATE `avalenti`.`Reminders` SET `Reminder` = 'immunization,wellness visit',
`Reminder_Method` = 'email,postcard',
`Reminder_Frequency` = 'twoWeeks' WHERE `Reminders`.`Pet_ID` =1 AND `Reminders`.`Reminder` = 'immunization,lab work' AND `Reminders`.`Reminder_Method` = 'email,text';
		 */
		
		//DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = 1 AND `Reminders`.`Reminder` = \'immunization,wellness visit\'
		
		if(immunizationReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'immunization\'", PetID);
			state.execute(commandstring);
		}
		else if(!reminderExists(PetID, "immunization")){
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'immunization', '%s', '%s');", Integer.toString(PetID),immunizationMethods, immunizationFrequency);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("UPDATE `avalenti`.`Reminders` SET `Reminder` = '%s', `Reminder_Method` = 'immunization',`Reminder_Frequency` = '%s' WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = 'immunization'", immunizationMethods, immunizationFrequency, PetID);
			state.execute(commandstring);
		}
		
		if(wellnessReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'wellness visit\'", PetID);
			state.execute(commandstring);
		}
		else if(!reminderExists(PetID, "wellness visit")){
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'wellness visit', '%s', '%s');", Integer.toString(PetID),wellnessMethods, wellnessFrequency);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("UPDATE `avalenti`.`Reminders` SET `Reminder` = '%s', `Reminder_Method` = 'wellness visit',`Reminder_Frequency` = '%s' WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = 'wellness visit'", wellnessMethods, wellnessFrequency, PetID);
			state.execute(commandstring);
		}
		
		if(labReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'lab work\'", PetID);
			state.execute(commandstring);
		}
		else if(!reminderExists(PetID, "lab work")){
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'lab work', '%s', '%s');", Integer.toString(PetID),labMethods, labFrequency);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("UPDATE `avalenti`.`Reminders` SET `Reminder` = '%s', `Reminder_Method` = 'lab work',`Reminder_Frequency` = '%s' WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = 'lab work'", labMethods, labFrequency, PetID);
			state.execute(commandstring);
		}
		state.close();
	}
	
	public void addReminders (List<String> immunizationReminder, List<String> wellnessReminder, List<String> labReminder) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		int PetID = getMostRecentPetID();
		String commandstring = "";
		String immunizationMethods = "";
		String wellnessMethods = "";
		String labMethods = "";
		String immunizationFrequency = immunizationReminder.get(immunizationReminder.size()-1);
		String wellnessFrequency = wellnessReminder.get(wellnessReminder.size()-1);
		String labFrequency = labReminder.get(labReminder.size()-1);
		
		if(!immunizationReminder.isEmpty()){
			for(int i = 0; i < immunizationReminder.size()-1; i++){
				if(immunizationMethods.compareTo("") == 0){
					immunizationMethods = immunizationReminder.get(i);
				}
				else{
					immunizationMethods = immunizationMethods + "," + immunizationReminder.get(i);
				}
			}
		}
		if(!wellnessReminder.isEmpty()){
			for(int i = 0; i < wellnessReminder.size()-1; i++){
				if(wellnessMethods.compareTo("") == 0){
					wellnessMethods = wellnessReminder.get(i);
				}
				else{
					wellnessMethods = wellnessMethods + "," + wellnessReminder.get(i);
				}
			}
		}
		if(!labReminder.isEmpty()){
			for(int i = 0; i < labReminder.size()-1; i++){
				if(labMethods.compareTo("") == 0){
					labMethods = labReminder.get(i);
				}
				else{
					labMethods = labMethods + "," + labReminder.get(i);
				}
			}
		}
		
		if(immunizationReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'immunization\'", PetID);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'immunization', '%s', '%s');", Integer.toString(PetID),immunizationMethods, immunizationFrequency);
			state.execute(commandstring);
		}
		
		if(wellnessReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'wellness visit\'", PetID);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'wellness visit', '%s', '%s');", Integer.toString(PetID),wellnessMethods, wellnessFrequency);
			state.execute(commandstring);
		}
		
		if(labReminder.isEmpty()){
			commandstring = String.format("DELETE FROM `avalenti`.`Reminders` WHERE `Reminders`.`Pet_ID` = %d AND `Reminders`.`Reminder` = \'lab work\'", PetID);
			state.execute(commandstring);
		}
		else{
			commandstring = String.format("INSERT INTO `avalenti`.`Reminders` (`Pet_ID`, `Reminder`, `Reminder_Method`, `Reminder_Frequency`) VALUES ('%s', 'lab work', '%s', '%s');", Integer.toString(PetID),labMethods, labFrequency);
			state.execute(commandstring);
		}
		state.close();
	}
	
	private boolean reminderExists(int PetID, String reminderType) throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT * FROM `avalenti`.`Reminders` WHERE `Pet_ID` = %d AND `Reminders`.`Reminder` = '%s';", PetID, reminderType);
		ResultSet rs = state.executeQuery(commandstring);
		if(rs.getFetchSize() == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	private int getMostRecentPetID() throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT MAX( `ID` ) AS ID FROM avalenti.Pets";
		ResultSet rs = state.executeQuery(commandstring);
		if(rs.next() == true){
			String id = rs.toString();
			int id1 = Integer.parseInt(rs.getString("ID"));
		}
		return Integer.parseInt(rs.getString("ID"));
	}
	
	public String toString(){
		return this.Name;
	}
}
