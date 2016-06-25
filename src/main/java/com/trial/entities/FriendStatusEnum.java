package com.trial.entities;

import java.io.Serializable;

public enum FriendStatusEnum  implements Serializable{
		
	Y ("Refresh Friend List"),
	N ("Not Refresh Friend List")
	;
	public final String description;
	
	FriendStatusEnum(final String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
