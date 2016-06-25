package com.trial.entities;

public enum AdTrackEnum {

	Y(true), N(false);
	public final boolean description;

	AdTrackEnum(final boolean description) {
		this.description = description;
	}

	public boolean getDescription() {
		return description;
	}

	public boolean isDescription() {
		return description;
	}

	public static AdTrackEnum getEnumType(final boolean value) {
		for (AdTrackEnum adTrackEnum : values()) {
			if (adTrackEnum.getDescription() == value) {
				return adTrackEnum;
			}
		}
		return null;
	}
}
