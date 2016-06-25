package com.trial.entities;

import java.io.Serializable;

/**
 * 
 * @author a039880
 * @version 1.0
 * 
 *          1.0 - ENUM to maintain different offer sources
 */
public enum OfferSourceEnum implements Serializable {

	GENERAL("GENERAL"), FRIEND("FRIEND"), FEATURED("FEATURED"), BROWSE("BROWSE"), SEARCH(
			"SEARCH"), OFFERDETAILS("OFFERDETAILS"),STORE("STORE"),EXTERNAL("EXTERNAL");

	private final String description;

	OfferSourceEnum(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
