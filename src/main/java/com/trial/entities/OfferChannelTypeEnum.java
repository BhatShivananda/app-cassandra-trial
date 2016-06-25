package com.trial.entities;

import java.io.Serializable;
/**
 * Used to distinguish Cartwheel and DMC Offer Channels
 * @author a570872
 *
 */
public enum OfferChannelTypeEnum implements Serializable {

	CWL("CWL"), DMC("DMC");
	private final String description;

	public String getDescription() {
		return description;
	}

	OfferChannelTypeEnum(final String description) {
		this.description = description;
	}

}
