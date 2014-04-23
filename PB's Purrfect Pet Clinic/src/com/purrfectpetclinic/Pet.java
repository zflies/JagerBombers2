package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
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
		}

		state.close();
		
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
	
	public String toString(){
		return this.Name;
	}
}
