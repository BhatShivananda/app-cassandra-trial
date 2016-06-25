package com.trial.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents a user of the app who intends to redeem the offers in the app
 * while buying from Target.
 * 
 * @author A039891
 * 
 */
/**
 * @author A541347
 *
 */
public class SSAUser implements Serializable {
	private static final long serialVersionUID = -3480640752721835060L;
	private String userId;
	private String firstName;
	private String lastName;
	private String displayName;
	private String userName;
	private Timestamp createdTimeStamp;
	private Timestamp updatedTimeStamp;
	private long slotSize;
	private Double totalAmountSaved;
	private UserStatusEnum status;
	private String email;
	private String targetEmail;
	private String barcode;
	private FriendStatusEnum friendsDirtyflag;
	//Barcode scan count at Point Of Sale
	private Integer barcodeScanCount;
	//Barcode scan date at Point Of Sale
	private List<String> redeemedPublicOfferIds;
	private List<BullsEyeOffer> bullsEyeOffers;
	private List<Map<String, Object>> friendList;
	private Map<Integer, String> userSettings;
	private Integer totalRedeemCount;
	//badge earned list
	private List<String> userBadges;
	//check with Sagar
	private List<String> userSlotAchievements;
	private List<String> undisplayedBadges;
	private UserGenderEnum gender;
	private Boolean firstTimeUser;
	private String loginDomainName;
	private boolean dirtyFlag;
	private long lastUpdtedTime;
	private boolean friendsDirty;
	//account id with which user logs in
	private String loggedInAccountId;
	private String advertiserId;
	private String cwlAppVer;
	private AdTrackEnum advTrackEnbl;
	private String refreshToken;
	private boolean friendPermission=false;
	private Timestamp refreshAccessTokenTS;
	private String preferredStoreId;
	
	
	public String getPreferredStoreId() {
		return preferredStoreId;
	}

	public void setPreferredStoreId(String preferredStoreId) {
		this.preferredStoreId = preferredStoreId;
	}

	public boolean isFriendPermission() {
		return friendPermission;
	}

	public void setFriendPermission(boolean friendPermission) {
		this.friendPermission = friendPermission;
	}

	public String getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}

	public String getCwlAppVer() {
		return cwlAppVer;
	}

	public void setCwlAppVer(String cwlAppVer) {
		this.cwlAppVer = cwlAppVer;
	}

	public AdTrackEnum isAdvTrackEnbl() {
		return advTrackEnbl;
	}

	public void setAdvTrackEnbl(AdTrackEnum advTrackEnbl) {
		this.advTrackEnbl = advTrackEnbl;
	}

	private List<UserAccount> userAccounts;
	
	
	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public String getLoggedInAccountId() {
		return loggedInAccountId;
	}

	public void setLoggedAccountId(String loggedInAccountId) {
		this.loggedInAccountId = loggedInAccountId;
	}

	private Date prevListCleanTime;
	
	public Date getPrevListCleanTime() {
		return prevListCleanTime;
	}

	public void setPrevListCleanTime(Date prevListCleanTime) {
		this.prevListCleanTime = prevListCleanTime;
	}

	public boolean isFriendsDirty() {
		return friendsDirty;
	}

	public void setFriendsDirty(boolean friendsDirty) {
		this.friendsDirty = friendsDirty;
	}

	public String getLoginDomainName() {
		return loginDomainName;
	}

	public void setLoginDomainName(String loginDomainName) {
		this.loginDomainName = loginDomainName;
	}

	public UserGenderEnum getGender() {
		return gender;
	}

	public void setGender(UserGenderEnum gender) {
		this.gender = gender;
	}

	public List<String> getUserSlotAchievements() {
		return userSlotAchievements;
	}

	public void setUserSlotAchievements(final List<String> userSlotAchievements) {
		this.userSlotAchievements = userSlotAchievements;
	}

	public List<String> getUserBadges() {
		return userBadges;
	}

	public void setUserBadges(final List<String> userBadges) {
		this.userBadges = userBadges;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @return the bullsEyeOffers
	 */
	public List<BullsEyeOffer> getBullsEyeOffers() {
		return bullsEyeOffers;
	}

	/**
	 * @return the createdTimeStamp
	 */
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		String userdisplayName = null;
		UserAccount account = getAccountOfType(SSALoginType.FACEBOOK);
		if(account==null){
			account = getAccountOfType(SSALoginType.GOOGLE);
		}
		if(account==null){
			account = getAccountOfType(SSALoginType.TARGET);
		}
		if(account!=null){
			// JIRA : 3310 : display name should have first name and last name
			userdisplayName = account.getFirstName() +" "+ account.getLastName(); 
			return userdisplayName;
		}else{
			return displayName;
		}
	}

	public UserAccount getAccountOfType(SSALoginType loginType) {
		if(userAccounts!=null && !userAccounts.isEmpty()){
			for (UserAccount userAccount : userAccounts) {
				if(userAccount.getLoginDomainName().equals(loginType.getType())){
					return userAccount;
				}
			}
		}
		return null;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the fbId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		UserAccount account = getAccountOfType(SSALoginType.FACEBOOK);
		if(account==null){
			account = getAccountOfType(SSALoginType.GOOGLE);
		}
		if(account==null){
			account = getAccountOfType(SSALoginType.TARGET);
		}
		if(account!=null){
			return account.getFirstName();
		}else{
			return firstName;
		}
	}

	/**
	 * Returns the List of <friendId, Name>
	 * 
	 * @return the friendList
	 */
	public List<Map<String, Object>> getFriendList() {
		return friendList;
	}

	/**
	 * @return the friendsDirtyflag
	 */
	public FriendStatusEnum getFriendsDirtyflag() {
		return friendsDirtyflag;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		UserAccount account = getAccountOfType(SSALoginType.FACEBOOK);
		if(account==null){
			account = getAccountOfType(SSALoginType.GOOGLE);
		}
		if(account==null){
			account = getAccountOfType(SSALoginType.TARGET);
		}
		if(account!=null){
			return account.getLastName();
		}else{
			return lastName;
		}
	}

	/**
	 * @return the redeemedPublicOfferIds
	 */
	public List<String> getRedeemedPublicOfferIds() {
		return redeemedPublicOfferIds;
	}

	/**
	 * @return the slotSize
	 */
	public long getSlotSize() {
		return slotSize;
	}

	/**
	 * @return the status
	 */
	public UserStatusEnum getStatus() {
		return status;
	}

	/**
	 * @return the targetEmail
	 */
	public String getTargetEmail() {
		return targetEmail;
	}

	/**
	 * @return the totalAmountSaved
	 */
	public Double getTotalAmountSaved() {
		return totalAmountSaved;
	}

	/**
	 * @return the updatedTimeStamp
	 */
	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	/**
	 * 
	 * @return
	 */
	public Map<Integer, String> getUserSettings() {
		return userSettings;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(final String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @param bullsEyeOffers
	 *            the bullsEyeOffers to set
	 */
	public void setBullsEyeOffers(final List<BullsEyeOffer> bullsEyeOffers) {
		this.bullsEyeOffers = bullsEyeOffers;
	}

	/**
	 * @param createdTimeStamp
	 *            the createdTimeStamp to set
	 */
	public void setCreatedTimeStamp(final Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param fbId
	 *            : the fbId to set
	 */
	public void setUserId(final String fbId) {
		this.userId = fbId;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Stores the List of Map<friendId, Name>
	 * 
	 * @param friendList
	 *            the friendList to set
	 */
	public void setFriendList(final List<Map<String, Object>> friendList) {
		this.friendList = friendList;
	}

	/**
	 * @param friendsDirtyflag
	 *            the friendsDirtyflag to set
	 */
	public void setFriendsDirtyflag(final FriendStatusEnum friendsDirtyflag) {
		this.friendsDirtyflag = friendsDirtyflag;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param redeemedPublicOfferIds
	 *            the redeemedPublicOfferIds to set
	 */
	public void setRedeemedPublicOfferIds(final List<String> redeemedPublicOfferIds) {
		this.redeemedPublicOfferIds = redeemedPublicOfferIds;
	}

	/**
	 * @param slotSize
	 *            the slotSize to set
	 */
	public void setSlotSize(final long slotSize) {
		this.slotSize = slotSize;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final UserStatusEnum status) {
		this.status = status;
	}

	/**
	 * @param targetEmail
	 *            the targetEmail to set
	 */
	public void setTargetEmail(final String targetEmail) {
		this.targetEmail = targetEmail;
	}

	/**
	 * @param totalAmountSaved
	 *            the totalAmountSaved to set
	 */
	public void setTotalAmountSaved(final Double totalAmountSaved) {
		this.totalAmountSaved = totalAmountSaved;
	}

	/**
	 * @param updatedTimeStamp
	 *            the updatedTimeStamp to set
	 */
	public void setUpdatedTimeStamp(final Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	/**
	 * 
	 * @param userSettings
	 */
	public void setUserSettings(final Map<Integer, String> userSettings) {
		this.userSettings = userSettings;
	}

	public List<String> getUndisplayedBadges() {
		return undisplayedBadges;
	}

	public void setUndisplayedBadges(List<String> undisplayedBadges) {
		this.undisplayedBadges = undisplayedBadges;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public Boolean getFirstTimeUser() {
		return firstTimeUser!=null?firstTimeUser:Boolean.FALSE;
	}

	public void setFirstTimeUser(Boolean firstTimeUser) {
		this.firstTimeUser = firstTimeUser;
	}

	/**
	 * @param dirtyFlag the dirtyFlag to set
	 */
	public void setDirtyFlag(boolean dirtyFlag) {
		this.dirtyFlag = dirtyFlag;
	}

	/**
	 * @return the dirtyFlag
	 */
	public boolean isDirtyFlag() {
		return dirtyFlag;
	}

	/**
	 * @param lastUpdtedTime the lastUpdtedTime to set
	 */
	public void setLastUpdtedTime(long lastUpdtedTime) {
		this.lastUpdtedTime = lastUpdtedTime;
	}

	/**
	 * @return the lastUpdtedTime
	 */
	public long getLastUpdtedTime() {
		return lastUpdtedTime;
	}

	public Integer getBarcodeScanCount() {
		return barcodeScanCount;
	}

	public void setBarcodeScanCount(Integer barcodeScanCount) {
		this.barcodeScanCount = barcodeScanCount;
	}
	
	public Integer getTotalRedeemCount() {
		return totalRedeemCount;
	}

	public void setTotalRedeemCount(Integer totalRedeemCount) {
		this.totalRedeemCount = totalRedeemCount;
	}

	public String getProfilePicAccId() {
		// default is any pic
		String profilePicId = getUserAccounts().get(0).getCwlAccountId();
		for (UserAccount account : getUserAccounts()) {
			if(account.getLoginDomainName().equals(SSALoginType.FACEBOOK.getType())){
				// prefer FB if found
				return account.getCwlAccountId();
			} else if (account.getLoginDomainName().equals(SSALoginType.GOOGLE.getType())){
				//FB not found until now, reset default to GGL pic and search further for FB
				profilePicId= account.getCwlAccountId();
			}
		}
		return profilePicId;
	}
	
	public String getSocialAccId() {
		for (UserAccount account : getUserAccounts()) {
			if(account.getLoginDomainName().equals(SSALoginType.FACEBOOK.getType())){
				return account.getCwlAccountId();
			}
		}
		return "";
	}
	
	public UserAccount getLatestUserBasedOnUpdateTimeStamp() {
		List<UserAccount> ls = getUserAccounts();
		if (ls != null && ls.size() > 1) {
			Collections.sort(ls, new Comparator<UserAccount>() {
				@Override
				public int compare(UserAccount o1, UserAccount o2) {
					return (o1.getUpdatedTimeStamp() == null) ? -1 : ((o2
							.getUpdatedTimeStamp() == null) ? 1 : (o1
							.getUpdatedTimeStamp().compareTo(o2
							.getUpdatedTimeStamp())));
				}
			});
			Collections.reverse(ls);
		}
		return ls.get(0);
	}

	public boolean hasLoginAccountOfType(String loginDomainName2) {
		List<UserAccount> ls = getUserAccounts();
		if (ls != null) {
			for (UserAccount userAccount : ls) {
				if(userAccount.getLoginDomainName().equals(loginDomainName2)){
					return true;
				} else { 
					continue;
				}
			}
		}
		return false;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * @return the refreshAccessTokenTS
	 */
	public Timestamp getRefreshAccessTokenTS() {
		return refreshAccessTokenTS;
	}

	/**
	 * @param refreshAccessTokenTS the refreshAccessTokenTS to set
	 */
	public void setRefreshAccessTokenTS(Timestamp refreshAccessTokenTS) {
		this.refreshAccessTokenTS = refreshAccessTokenTS;
	}
	
	public UserAccount getOldestAccount(){
	  Iterator<UserAccount> userAccounts = getUserAccounts().listIterator();
	  UserAccount oldestUserAccount = userAccounts.next();
        
      while (userAccounts.hasNext()){
        UserAccount tmAcc = userAccounts.next();
        oldestUserAccount = oldestUserAccount.getCreatedTimeStamp().before(tmAcc.getCreatedTimeStamp())?oldestUserAccount:tmAcc;
      };
	  return oldestUserAccount;
	}
	
	public boolean isPerfUser() {
		if(targetEmail != null && targetEmail.equals("PerfUser")) {
			return true;
		}
		return false;
	}
	
}
