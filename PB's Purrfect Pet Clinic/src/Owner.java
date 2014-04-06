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
	
	public Vector<Pet> getPets(){
		return this.Pets;
	}
	
	public void addPet(Pet newPet){
		this.Pets.add(newPet);
	}
}
