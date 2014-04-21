import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


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
