package com.trial.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Represents a user of the app who intends to redeem the offers in the app
 * while buying from Target.
 * 
 * @author A039891
 * 
 */
public class UserAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6446493470597768022L;
	private String userId;
	private String firstName;
	private String lastName;
	private String displayName;
	private long slotSize;
	private Double totalAmountSaved;
	private UserStatusEnum status;
	private String email;
	private String loginDomainName;
	private String cwlAccountId;
	private UserGenderEnum gender;
	private String barcode;
	private FriendStatusEnum friendsDirtyflag;
	private Timestamp createdTimeStamp;
	private Timestamp updatedTimeStamp;
	private Integer redeemCount;
	private String refreshToken;
	private String accessToken;
	private String profilePic;
	private String oldAccessToken;
	private long oldAccessTokenTS;
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public FriendStatusEnum getFriendsDirtyflag() {
		return friendsDirtyflag;
	}

	public void setFriendsDirtyflag(FriendStatusEnum friendsDirtyflag) {
		this.friendsDirtyflag = friendsDirtyflag;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public UserGenderEnum getGender() {
		return gender;
	}

	public void setGender(UserGenderEnum gender) {
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getSlotSize() {
		return slotSize;
	}

	public void setSlotSize(long slotSize) {
		this.slotSize = slotSize;
	}

	public Double getTotalAmountSaved() {
		return totalAmountSaved;
	}

	public void setTotalAmountSaved(Double totalAmountSaved) {
		this.totalAmountSaved = totalAmountSaved;
	}

	public UserStatusEnum getStatus() {
		return status;
	}

	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginDomainName() {
		return loginDomainName;
	}

	public void setLoginDomainName(String loginDomainName) {
		this.loginDomainName = loginDomainName;
	}

	public String getCwlAccountId() {
		return cwlAccountId;
	}

	public void setCwlAccountId(String cwlAccountId) {
		this.cwlAccountId = cwlAccountId;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Integer getRedeemCount() {
		return redeemCount;
	}

	public void setRedeemCount(Integer redeemCount) {
		this.redeemCount = redeemCount;
	}

	public String getOldAccessToken() {
		return oldAccessToken;
	}

	public void setOldAccessToken(String oldAccessToken) {
		this.oldAccessToken = oldAccessToken;
	}

	public long getOldAccessTokenTS() {
		return oldAccessTokenTS;
	}

	public void setOldAccessTokenTS(long oldAccessTokenTS) {
		this.oldAccessTokenTS = oldAccessTokenTS;
	}

}
