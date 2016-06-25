/**
 * 
 */
package com.trial.entities;

import java.io.Serializable;

/**
 * @author A039880
 * 
 */
public enum SSALoginType  implements Serializable{
	FACEBOOK("FB"), TARGET("TGT"), GOOGLE("GGL"), TWITTER("TWT");

	private final String type;

	public String getType() {
		return type;
	}

	SSALoginType(final String type) {
		this.type = type;
	}

	public static SSALoginType getValueFromString(final String value) {
		for (SSALoginType loginType : values()) {
			if (loginType.getType().equals(value)) {
				return loginType;
			}
		}
		return null;
	}
}
