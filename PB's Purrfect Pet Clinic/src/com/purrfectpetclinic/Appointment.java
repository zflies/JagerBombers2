package com.purrfectpetclinic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.sql.Statement;


public class Appointment {

	public static enum Completed{
		yes,
		no;
	}

	final int nAppointmentID;
	final int nPetID;
	final int nVetID;
	final String sServiceName;
	final Date dateSelected;
	final String sTimeSelected;
	final Completed completed;
	final String sNotes;	

	public Appointment( int appointmentID, int petID, String serviceName, int vetID, Date date, String time, String completeValue, String notes )
	{
		this.nAppointmentID = appointmentID;
		this.nPetID = petID;
		this.sServiceName = serviceName;
		this.nVetID = vetID;
		this.dateSelected = date;
		this.sTimeSelected = time;

		if(completeValue.compareTo("yes") == 0)
			this.completed = Completed.yes;
		else
			this.completed = Completed.no;

		this.sNotes = notes;
	}


	public int getAppointmentID() {
		return this.nAppointmentID;
	}
	public int getPetID() {
		return this.nPetID;
	}

	public String getServiceName() {
		return this.sServiceName;
	}
	
	public int getVetID() {
		return this.nVetID;
	}

	public Date getDateSelected() {
		return this.dateSelected;
	}

	public String getTimeSelected() {
		return this.sTimeSelected;
	}

	public Completed getCompleted(){
		return this.completed;
	}

	public String getNotes() {
		return this.sNotes;
	}

	/**
	 * Returns the Pet object associated with the appointment
	 * @return
	 */
	public Pet getPet() {
		
		Statement state = DBConnection.OpenConnection();

		String commandstring = "SELECT * FROM Pets WHERE ID = '" + this.nPetID + "';"; 

		Pet pet = null;

		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				rs.next();

				String PetTypeString = rs.getString("Type");
				Pet.Type PetType;
				if(PetTypeString.compareTo("dog") == 0)
					PetType = Pet.Type.dog;
				else
					PetType = Pet.Type.cat;

				String Name = rs.getString("Name");
				String OwnerName = "";		
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

				pet = new Pet(PetType, Name, OwnerName, PetSex, PetSize, Color, DateOfBirth, Prescriptions, Weight, Breed, Notes);

				state.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error: Appointment.java - getPet()");

			}
		}
		else
			System.err.println("Error: Appointment.java - getPet()");
		
		return pet;

	} // end of function getPet()
	
	
	/**
	 * Returns the Owner object associated with the appointment
	 * @return
	 */
	public Owner getOwner() {
		Statement state = DBConnection.OpenConnection();

		String commandstring = "SELECT * FROM Owner WHERE ID = (SELECT Owner_ID FROM pets WHERE ID = '" + this.nPetID + "');"; 

		Owner owner = null;
		
		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				rs.next();
				String FirstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Address = rs.getString("Address");
				String City = rs.getString("City");
				String State = rs.getString("State");
				String Zip = rs.getString("Zip");
				String Phone = rs.getString("Phone");

				owner = new Owner(FirstName, LastName, Address, City, State, Zip, Phone);

				state.close();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					System.out.println("Error: Appointment.java - getOwner()");
				}
			}
			else
				System.err.println("Error: Appointment.java - getOwner()");
					
		return owner;
	} // end of function getOwner()

	
	/**
	 * Inserts a new appointment into the DB.
	 */
	public void createAppointment(){

		Statement state = DBConnection.OpenConnection();

		@SuppressWarnings("deprecation")
		String sDate = (this.dateSelected.getYear() + 1900) + "-" + this.dateSelected.getMonth() + "-" + this.dateSelected.getDate();

		String commandstring = String.format("INSERT INTO Appointments (Pet_ID, Service_Name, Vet_ID, Date, Time, Completed, Notes) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
				this.nPetID, this.sServiceName, this.nVetID, sDate, this.sTimeSelected, this.completed.toString(), this.sNotes);
		try {
			state.execute(commandstring);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} // end of createAppointment()
	
	
	/**
	 * Deletes an appointment from the DB
	 */
	public void deleteAppointment(){
		
		String sYear = (this.dateSelected.getYear() + 1900) + "";
		String sMonth = ( this.dateSelected.getMonth() + 1 ) + "";
		String sDay = this.dateSelected.getDate() + "";

		if ( sMonth.length() < 2 )
		{
			sMonth = "0" + sMonth;
		}

		if ( sDay.length() < 2 )
		{
			sDay = "0" + sDay;
		}

		String sDate = sYear + "-" + sMonth + "-" + sDay;
		
		Statement state = DBConnection.OpenConnection();
		String commandstring = String.format("DELETE FROM appointments WHERE Pet_ID = '%s' AND Date = '%s' AND Time = '%s' AND Service_Name = '%s'", this.nPetID, sDate, this.sTimeSelected, this.sServiceName );
		if(state != null){
			try {
				state.execute(commandstring);
				
				state.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error: Appointment.java - deleteAppointment()");
			}
		}
		else
			System.err.println("Error: Appointment.java - deleteAppointment()");
		
	} // end of deleteAppointment()


	/**
	 * Returns the appointments for a given date in a vector, sorted by the appointment's time
	 * @param currDate
	 * @return
	 */
	public static Vector<Appointment>  getDayAppointments ( Date currDate ) 
	{
		Vector<Appointment> DayAppointments = new Vector<Appointment>();					//< Holds the appointments for a single day

		Statement state = DBConnection.OpenConnection();

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

		String sDate = sYear + "-" + sMonth + "-" + sDay;

		String commandstring = "";

		commandstring = "SELECT * FROM Appointments WHERE Date = '" + sDate + "' ORDER BY Time;"; //ORDER BY ID DESC;";

		int ID = 0;
		int Pet_ID = 0;
		String Service_Name = "";
		int Vet_ID = 1;
		Date Date;
		String Time = "";
		String Completed = "";
		String Notes = "";

		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				while(rs.next()) {

					ID = rs.getInt("ID");
					Pet_ID = rs.getInt("Pet_ID");
					Service_Name = rs.getString("Service_Name");
					Vet_ID = rs.getInt("Vet_ID");
					Date = rs.getDate("Date");
					Time = rs.getString("Time");
					Completed = rs.getString("Completed");
					Notes = rs.getString("Notes");
					Appointment new_appointment = new Appointment(ID, Pet_ID, Service_Name, Vet_ID, Date, Time, Completed, Notes);
					DayAppointments.add(new_appointment);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error: Appointment.java - getWeekAppointments()");
			}
		}
		else
			System.err.println("Error: Appointment.java - getWeekAppointments()");
		
		try {
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return DayAppointments;	

	} // end of function getWeekAppointments()
	
	

}
