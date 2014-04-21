import java.util.Date;


public class Immunization {
	final ImmunizationType Name;
	final Date StartDate;
	final Date EndDate;
	
	public static int RabiesTime = 3;
	public static int DistemperTime = 3;
	public static int BordatellaTime = 1;
	
	public static enum ImmunizationType{
		Rabies,
		Distemper,
		Bordatella;
	}
	
	public Immunization(ImmunizationType name, Date start, Date end){
		Name = name;
		StartDate = start;
		EndDate = end;
	}
	
	public String getImmunizationNameString(){
		if(this.Name == ImmunizationType.Rabies)
			return "Rabies";
		else if(this.Name == ImmunizationType.Distemper)
			return "Distemper";
		else 
			return "Bordatella";
	}
	
	public Date getStartDate(){
		return this.StartDate;
	}
	
	public Date getEndDate(){
		return this.EndDate;
	}
	
	public ImmunizationType getImmunizationType(){
		return this.Name;
	}
}
