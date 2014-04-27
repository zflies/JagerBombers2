package com.purrfectpetclinic;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class PetFood {
	public static enum Type{
		Kitten,
		AdultCat,
		AdultCatLowFat,
		SeniorCat,
		PuppySmall,
		PuppyLarge,
		AdultDog,
		AdultDogLowFat,
		SeniorDog;
	}
	//age restrictions
	public static int MAXKITTENAGE = 1;
	public static int MAXPUPPYAGE = 1;
	public static int SENIORCATAGE = 11;
	public static int SENIORDOGAGE = 8;
	
	//food amounts by weight
	public static double CATLESSTHANFIVEPOUNDS = 0.5;
	public static double CATLESSTHANTENPOUNDS = 0.75;
	public static double CATGREATERTHANTENPOUNDS = 1.0;
	public static double DOGLESSTHANTENPOUNDS = 0.5;
	public static double DOGLESSTHANTWENTYPOUNDS = 1.0;
	public static double DOGLESSTHANTHIRTYPOUNDS = 1.5;
	public static double DOGLESSTHANFOURTYPOUNDS = 2.0;
	public static double DOGLESSTHANSIXTYPOUNDS = 2.5;
	public static double DOGLESSTHANEIGHTYPOUNDS = 3.25;
	public static double DOGLESSTHANONEHUNDREDPOUNDS = 4.0;
	public static double DOGHUNDREDPLUSPOUNDS = 4.25;
	
	
	Type FoodType;
	Double Amount;
	
	public PetFood(Type food, Double amount){
		FoodType = food;
		Amount = amount;
	}
	
	public void IncAmount(Double addAmount){
		Amount = Amount + addAmount;
	}
	
	public void convertCupsToPounds(){
		Amount = Amount/5.0;
	}
	
	private static int getAge(Date dateOfBirth) {

	    Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();

	    int age = 0;

	    birthDate.setTime(dateOfBirth);
	    if (birthDate.after(today)) {
	        throw new IllegalArgumentException("Can't be born in the future");
	    }

	    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
	    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
	            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
	        age--;

	     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
	    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
	              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
	        age--;
	    }

	    return age;
	}
	
	public static Vector<PetFood> getFoodWeights(Date weekStart, Date weekEnd) throws SQLException{
		Vector<PetFood> FoodWeights = new Vector<PetFood>();
		Vector<Boarding> AllBoarding = Boarding.getAllBoardingEntries();
		Date curDate = new Date();
		//initialize starting amounts to 0
		PetFood Kitten = new PetFood(Type.Kitten, 0.0);
		PetFood AdultCat = new PetFood(Type.AdultCat, 0.0);
		PetFood AdultCatLowFat = new PetFood(Type.AdultCatLowFat, 0.0);
		PetFood SeniorCat = new PetFood(Type.SeniorCat, 0.0);
		PetFood PuppySmall = new PetFood(Type.PuppySmall, 0.0);
		PetFood PuppyLarge = new PetFood(Type.PuppyLarge, 0.0);
		PetFood AdultDog = new PetFood(Type.AdultDog, 0.0);
		PetFood AdultDogLowFat = new PetFood(Type.AdultDogLowFat, 0.0);
		PetFood SeniorDog = new PetFood(Type.SeniorDog, 0.0);
		
		//add up food weights
		for(int i = 0; i < AllBoarding.size(); i++){
			Boarding curBoarding = AllBoarding.elementAt(i);
			//check if current boarding session applies to date range
			if(curBoarding.getEndDate().before(weekStart) || curBoarding.getStartDate().after(weekEnd))
				continue;
			Pet curPet = curBoarding.getPet();
			//if pet is a cat
			if(curPet.getPetType() == Pet.Type.cat){
				//create age flags
				boolean kitten = false;
				boolean adultcat = false;
				boolean seniorcat = false;
				
				//get pet age and set age flag
				int petAge = getAge(curPet.getDOB());
				if(petAge <= MAXKITTENAGE)
					kitten = true;
				else if(petAge < SENIORCATAGE)
					adultcat = true;
				else
					seniorcat = true;
				
				//determine cups of food needed
				double petWeight = curPet.getWeight();
				double cupAmount = 0.0;
				if(petWeight < 5.0)
					cupAmount = CATLESSTHANFIVEPOUNDS;
				else if(petWeight < 10.0)
					cupAmount = CATLESSTHANTENPOUNDS;
				else
					cupAmount = CATGREATERTHANTENPOUNDS;
				
				//determine if low fat diet needed
				boolean lowfat = false;
				if(adultcat == true){
					if(curBoarding.getOptions().contains(Boarding.Options.lowfatfood))
						lowfat = true;
				}
				
				//add to food type
				if(kitten)
					Kitten.IncAmount(cupAmount);
				else if(adultcat && !lowfat)
					AdultCat.IncAmount(cupAmount);
				else if(adultcat && lowfat)
					AdultCatLowFat.IncAmount(cupAmount);
				else
					SeniorCat.IncAmount(cupAmount);
			}
			//if pet is a dog
			else{
				//create age flags
				boolean puppysmall = false;
				boolean puppylarge = false;
				boolean adultdog = false;
				boolean seniordog = false;
				
				//get pet age and set age flag
				int petAge = getAge(curPet.getDOB());
				if(petAge <= MAXPUPPYAGE && curPet.getPetSize() == Pet.Size.small)
					puppysmall = true;
				else if(petAge <= MAXPUPPYAGE && curPet.getPetSize() != Pet.Size.small)
					puppylarge = true;
				else if(petAge < SENIORDOGAGE)
					adultdog = true;
				else
					seniordog = true;
				
				//determine cups of food needed
				double petWeight = curPet.getWeight();
				double cupAmount = 0.0;
				if(petWeight < 10.0)
					cupAmount = DOGLESSTHANTENPOUNDS;
				else if(petWeight < 20.0)
					cupAmount = DOGLESSTHANTWENTYPOUNDS;
				else if(petWeight < 30.0)
					cupAmount = DOGLESSTHANTHIRTYPOUNDS;
				else if(petWeight < 40.0)
					cupAmount = DOGLESSTHANFOURTYPOUNDS;
				else if(petWeight < 60.0)
					cupAmount = DOGLESSTHANSIXTYPOUNDS;
				else if(petWeight < 80.0)
					cupAmount = DOGLESSTHANEIGHTYPOUNDS;
				else if(petWeight < 100.0)
					cupAmount = DOGLESSTHANONEHUNDREDPOUNDS;
				else
					cupAmount = DOGHUNDREDPLUSPOUNDS;
				
				//determine if low fat diet needed
				boolean lowfat = false;
				if(adultdog == true){
					if(curBoarding.getOptions().contains(Boarding.Options.lowfatfood))
						lowfat = true;
				}
				
				//add to food type
				if(puppysmall)
					PuppySmall.IncAmount(cupAmount);
				else if(puppylarge)
					PuppyLarge.IncAmount(cupAmount);
				else if(adultdog && !lowfat)
					AdultDog.IncAmount(cupAmount);
				else if(adultdog && lowfat)
					AdultDogLowFat.IncAmount(cupAmount);
				else
					SeniorCat.IncAmount(cupAmount);
			}
		}
		
		//convert foodweights from cups to pounds
		Kitten.convertCupsToPounds();
		AdultCat.convertCupsToPounds();
		AdultCatLowFat.convertCupsToPounds();
		SeniorCat.convertCupsToPounds();
		PuppySmall.convertCupsToPounds();
		PuppyLarge.convertCupsToPounds();
		AdultDog.convertCupsToPounds();
		AdultDogLowFat.convertCupsToPounds();
		SeniorDog.convertCupsToPounds();
		
		//add food-weights to vector
		FoodWeights.add(Kitten);
		FoodWeights.add(AdultCat);
		FoodWeights.add(AdultCatLowFat);
		FoodWeights.add(SeniorCat);
		FoodWeights.add(PuppySmall);
		FoodWeights.add(PuppyLarge);
		FoodWeights.add(AdultDog);
		FoodWeights.add(AdultDogLowFat);
		FoodWeights.add(SeniorDog);
		return FoodWeights;
	}
	
}
