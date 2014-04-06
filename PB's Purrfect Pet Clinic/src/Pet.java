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
	
	final Type Type;
	final String Name;
	final String OwnerName;
	final Sex Sex;
	final Size Size;
	final String Color;
	final Date DateOfBirth;
	final String Prescriptions;
	final Double Weight;
	
	public Pet(Type type, String name, String owner, Sex sex, Size size, String color, Date dob, String prescriptions, Double weight){
		this.Type = type;
		this.Name = name;
		this.OwnerName = owner;
		this.Sex = sex;
		this.Size = size;
		this.Color = color;
		this.DateOfBirth = dob;
		this.Prescriptions = prescriptions;
		this.Weight = weight;
	}
	
	public String getTypeString(){
		if(this.Type == Type.cat)
			return "Cat";
		else
			return "Dog";
	}
	
	public Type getType(){
		return this.Type;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public String getOwnerName(){
		return this.OwnerName;
	}
	
	public String getSexString(){
		if(this.Sex == Sex.female)
			return "Female";
		else
			return "Male";
	}
	
	public Sex getSex(){
		return this.Sex;
	}
	
	public String getSizeString(){
		if(this.Size == Size.small)
			return "Small";
		else if(this.Size == Size.medium)
			return "Medium";
		else
			return "Large";
	}
	
	public Size getSize(){
		return this.Size;
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
}
