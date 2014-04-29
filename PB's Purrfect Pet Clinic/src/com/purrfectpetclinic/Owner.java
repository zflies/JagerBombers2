package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;


public class Owner {
	final String FirstName;
	final String LastName;
	final String Address;
	final String City;
	final String State;
	final String Zip;
	final String Phone;
	
	Vector<Pet> Pets;
	
	public Owner(String firstname, String lastname, String address, String city, String state, String zip, String phone){
		this.FirstName = firstname;
		this.LastName = lastname;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Zip = zip;
		this.Phone = phone;
		
		this.Pets = new Vector<Pet>();
	}
	
	public Owner(String firstname, String lastname, String address, String city, String state, String zip, String phone, Vector<Pet> pets){
		this.FirstName = firstname;
		this.LastName = lastname;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Zip = zip;
		this.Phone = phone;
		
		this.Pets = pets;
	}
	
	public String getFirstName(){
		return this.FirstName;
	}
	
	public String getLastName(){
		return this.LastName;
	}
	
	public String getFullName(){
		return this.FirstName + " " + this.LastName;
	}
	
	public String getListName(){
		return this.LastName + ", " + this.FirstName;
	}
	
	public String getAddress(){
		return this.Address;
	}
	
	public String getCity(){
		return this.City;
	}
	
	public String getState(){
		return this.State;
	}
	
	public String getZip(){
		return this.Zip;
	}
	
	public String getPhone(){
		return this.Phone;
	}
	
	public Vector<Pet> getPets(){
		return this.Pets;
	}
	
	public void addPet(Pet newPet){
		this.Pets.add(newPet);
	}
	
	public int getID() throws SQLException{
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("SELECT ID FROM Owner WHERE FirstName = '%s' AND LastName = '%s'", FirstName, LastName);
		ResultSet rs = state.executeQuery(commandstring);
		rs.next();
		int ID = rs.getInt("ID");
		state.close();
		rs.close();
		return ID;
	}
	
	public void getPetsDB() throws Exception{
		Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT * FROM Pets WHERE Pets.Owner_ID = (SELECT ID FROM Owner WHERE FirstName = '" + this.FirstName + "' AND LastName = '" + this.LastName + "') ORDER BY Name ASC;";
		
		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				while(rs.next()) {
					String PetTypeString = rs.getString("Type");
					Pet.Type PetType;
					if(PetTypeString.compareTo("dog") == 0)
						PetType = Pet.Type.dog;
					else
						PetType = Pet.Type.cat;
					
					String Name = rs.getString("Name");
					String OwnerName = this.getFullName();
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
					int PetID = newPet.getID(this.getID());
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
					
					//get Reminders of pet
					Statement state3 = DBConnection.OpenConnection();
					commandstring = String.format("SELECT * FROM Reminders WHERE Pet_ID = %d", PetID);
					ResultSet rs3 = state2.executeQuery(commandstring);
					while(rs3.next()){
						String reminder = rs3.getString("Reminder");
						String reminderMethod = rs3.getString("Reminder_Method");
						String reminderFrequency = rs3.getString("Reminder_Frequency");
						Reminder petReminder = new Reminder(reminder, reminderMethod, reminderFrequency);
						newPet.Reminders.add(petReminder);
					}
					state3.close();
					this.Pets.add(newPet);
					state2.close();
				}

				rs.close();
				state.close();


			} catch (SQLException e) {
				throw new Exception("Error in SQL Execution");
				}
		}
		else
			System.err.println("Statement was null.  No connection?");
	}
	
	public static Vector<Owner> getAllOwners() throws Exception{
		Vector<Owner> Owners = new Vector<Owner>();
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT * FROM Owner ORDER BY LastName ASC;";
		
		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				while(rs.next()) {
					String FirstName = rs.getString("FirstName");
					String LastName = rs.getString("LastName");
					String Address = rs.getString("Address");
					String City = rs.getString("City");
					String State = rs.getString("State");
					String Zip = rs.getString("Zip");
					String Phone = rs.getString("Phone");
					
					Owner newOwner = new Owner(FirstName, LastName, Address, City, State, Zip, Phone);
					newOwner.getPetsDB();
					Owners.add(newOwner);
				}

				rs.close();
				state.close();
			} catch (SQLException e) {
				throw new Exception("Error in SQL Execution");
				}
		}
		else
			System.err.println("Statement was null.  No connection?");
		return Owners;
	
	}
	
	public void addOwnerDB() throws SQLException{
		//add this Owner to the DB
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("INSERT INTO Owner (FirstName, LastName, Address, City, State, Zip, Phone) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
				FirstName, LastName, Address, City, State, Zip, Phone);
		state.execute(commandstring);
		state.close();
	}
	
	public void replaceOwner(Owner oldOwner) throws Exception{
		//open connection to DB
		Statement state = DBConnection.OpenConnection();
		
		//Find OwnerID of owner being replaced
		String commandstring = String.format("SELECT ID FROM Owner WHERE FirstName = '%s' AND LastName = '%s' AND Phone = '%s';",
				oldOwner.getFirstName(), oldOwner.getLastName(), oldOwner.getPhone());
		
		if(state != null){
				ResultSet rs = state.executeQuery(commandstring);
				rs.next();
				int ID = rs.getInt("ID");
				
				//update owner record in DB
				commandstring = String.format("UPDATE Owner SET FirstName = '%s', LastName = '%s', Address = '%s', City = '%s', State = '%s', Zip = '%s', Phone = '%s' WHERE ID = %d",
						FirstName, LastName, Address, City, State, Zip, Phone, ID);
				
				state.execute(commandstring);
				rs.close();
				state.close();
		}
		else
			System.err.println("Statement was null.  No connection?");
	}
	
	public void deleteOwner() throws SQLException{
		Statement state = DBConnection.OpenConnection();
		//Find OwnerID of owner being replaced
		String commandstring = String.format("SELECT ID FROM Owner WHERE FirstName = '%s' AND LastName = '%s' AND Phone = '%s';",
						this.getFirstName(), this.getLastName(), this.getPhone());
		
		int ID;
		if(state != null){
			ResultSet rs = state.executeQuery(commandstring);
			rs.next();
			ID = rs.getInt("ID");
			rs.close();
		}
		else{
			System.err.println("Statement was null.  No connection?");
			return;
		}
		//delete owner from DB
		commandstring = String.format("DELETE FROM Owner WHERE ID = %d;", ID);
		state.execute(commandstring);
		
		//delete the owners pets from DB
		commandstring = String.format("DELETE FROM Pets WHERE Owner_ID = %d;", ID);
		state.execute(commandstring);
		
		state.close();
	}
	
	public String toString(){
		return this.LastName + ", " + this.FirstName;
	}
}
