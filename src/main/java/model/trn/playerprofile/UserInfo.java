
package model.trn.playerprofile;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserInfo {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("isPremium")
    @Expose
    private Boolean isPremium;
    @SerializedName("isVerified")
    @Expose
    private Boolean isVerified;
    @SerializedName("isInfluencer")
    @Expose
    private Boolean isInfluencer;
    @SerializedName("isPartner")
    @Expose
    private Boolean isPartner;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("customAvatarUrl")
    @Expose
    private String customAvatarUrl;
    @SerializedName("customHeroUrl")
    @Expose
    private String customHeroUrl;
    @SerializedName("socialAccounts")
    @Expose
    private List<Object> socialAccounts = null;
    @SerializedName("pageviews")
    @Expose
    private Integer pageviews;
    @SerializedName("isSuspicious")
    @Expose
    private Boolean isSuspicious;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsInfluencer() {
        return isInfluencer;
    }

    public void setIsInfluencer(Boolean isInfluencer) {
        this.isInfluencer = isInfluencer;
    }

    public Boolean getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(Boolean isPartner) {
        this.isPartner = isPartner;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCustomAvatarUrl() {
        return customAvatarUrl;
    }

    public void setCustomAvatarUrl(String customAvatarUrl) {
        this.customAvatarUrl = customAvatarUrl;
    }

    public String getCustomHeroUrl() {
        return customHeroUrl;
    }

    public void setCustomHeroUrl(String customHeroUrl) {
        this.customHeroUrl = customHeroUrl;
    }

    public List<Object> getSocialAccounts() {
        return socialAccounts;
    }

    public void setSocialAccounts(List<Object> socialAccounts) {
        this.socialAccounts = socialAccounts;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Boolean getIsSuspicious() {
        return isSuspicious;
    }

    public void setIsSuspicious(Boolean isSuspicious) {
        this.isSuspicious = isSuspicious;
    }

}
