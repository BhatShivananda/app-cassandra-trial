package com.trial.entities;

import java.io.Serializable;

public enum UserGenderEnum  implements Serializable{
	MALE("male"),
	FEMALE("female"),
	UNKNOWN("unknown");
	private final String description;
	private UserGenderEnum(final String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public static UserGenderEnum getUserGenderEnumName(String description){
		UserGenderEnum[] values = UserGenderEnum.values();
		UserGenderEnum returnEnum = null;
		for(UserGenderEnum genderEnum : values){
			if(description.equals(genderEnum.getDescription())){
				returnEnum = genderEnum;
				break;
			}
		}
		return returnEnum;
	}
}
