package com.purrfectpetclinic;
public class Reminder{
	public static enum ReminderType{
		immunization,
		labWork,
		wellnessVisit;
	}
	
	public static enum ReminderFrequency{
		oneWeek,
		oneWeeks,
		oneMonth;
	}
	
	public static enum ReminderMethod{
		email,
		text,
		postcard;
	}
	
	public ReminderType type;
	public ReminderFrequency frequency;
	public ReminderMethod method;
	
	public Reminder(ReminderType Type, ReminderFrequency Frequency, ReminderMethod Method){
		this.type = Type;
		this.frequency = Frequency;
		this.method = Method;
	}
}