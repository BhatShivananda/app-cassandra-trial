package com.trial.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Represents the offers Customer has added/redeem to his bulls eye list.
 * @author A039891
 *
 */
public class BullsEyeOffer implements Serializable{

	private static final long serialVersionUID = 2291220265286443129L;
	private String offerId;
	private UserActionEnum action;
	private OfferSourceEnum userOfferTypeEnum;
	private Timestamp createdTimeStamp;
	private String userId;
	private Double amountSaved;
	private Boolean privateOffer=false;
	private String cwlAccountId;
	private OfferChannelTypeEnum offerChannelType;
	/**
	 * @return the offerChannelType
	 */
	public OfferChannelTypeEnum getOfferChannelType() {
		return offerChannelType;
	}
	/**
	 * @param offerChannelType the offerChannelType to set
	 */
	public void setOfferChannelType(OfferChannelTypeEnum offerChannelType) {
		this.offerChannelType = offerChannelType;
	}
	/**
	 * @return the action
	 */
	public UserActionEnum getAction() {
		return action;
	}
	/**
	 * @return the amountSaved
	 */
	public Double getAmountSaved() {
		return amountSaved;
	}
	/**
	 * @return the createdTimeStamp
	 */
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	/**
	 * @return the fbId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}
	public Boolean getPrivateOffer() {
		return privateOffer;
	}
	/**
	 * @return the userOfferTypeEnum
	 */
	public OfferSourceEnum getUserOfferTypeEnum() {
		return userOfferTypeEnum;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(final UserActionEnum action) {
		this.action = action;
	}
	/**
	 * @param amountSaved the amountSaved to set
	 */
	public void setAmountSaved(final Double amountSaved) {
		this.amountSaved = amountSaved;
	}
	/**
	 * @param createdTimeStamp the createdTimeStamp to set
	 */
	public void setCreatedTimeStamp(final Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	/**
	 * @param fbId the fbId to set
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}
	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(final String offerId) {
		this.offerId = offerId;
	}
	
	public void setPrivateOffer(final Boolean privateOffer) {
		this.privateOffer = privateOffer;
	}
	
	/**
	 * @param userOfferTypeEnum the userOfferTypeEnum to set
	 */
	public void setUserOfferTypeEnum(final OfferSourceEnum userOfferTypeEnum) {
		this.userOfferTypeEnum = userOfferTypeEnum;
	}

	public String getCwlAccountId() {
		return cwlAccountId;
	}
	public void setCwlAccountId(String cwlAccountId) {
		this.cwlAccountId = cwlAccountId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BullsEyeOffer other = (BullsEyeOffer) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		return result;
	}
}
