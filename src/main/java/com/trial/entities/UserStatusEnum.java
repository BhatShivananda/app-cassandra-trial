package com.trial.entities;

import java.io.Serializable;

/**
 * 
 * @author A040252
 *
 */
public enum UserStatusEnum implements Serializable {
	
	Y ("ACTIVE"),
	N ("INACTIVE"),
	M ("MERGED")
	;
	public final String description;
	
	UserStatusEnum(final String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
