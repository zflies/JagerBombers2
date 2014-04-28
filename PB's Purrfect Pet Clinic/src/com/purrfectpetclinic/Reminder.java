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
	
	public String typeDisplay;
	public String frequencyDisplay;
	public String methodDisplay;
	
	public Reminder(ReminderType Type, ReminderFrequency Frequency, ReminderMethod Method){
		this.type = Type;
		this.frequency = Frequency;
		this.method = Method;
	}

	public Reminder(String reminder, String reminderMethod, String reminderFrequency) {
		this.typeDisplay = reminder;
		this.methodDisplay = reminderMethod;
		this.frequencyDisplay = reminderFrequency;
	}
}