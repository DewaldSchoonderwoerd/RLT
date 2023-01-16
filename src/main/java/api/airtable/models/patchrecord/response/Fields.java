package api.airtable.models.patchrecord.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Fields {

    @SerializedName("doubles")
    @Expose
    private Integer doubles;
    @SerializedName("average")
    @Expose
    private Integer average;
    @SerializedName("discord")
    @Expose
    private String discord;
    @SerializedName("soloduel")
    @Expose
    private Integer soloduel;
    @SerializedName("gamertag")
    @Expose
    private String gamertag;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("standard")
    @Expose
    private Integer standard;
    @SerializedName("updated")
    @Expose
    private String updated;

    public Integer getDoubles() {
        return doubles;
    }

    public void setDoubles(Integer doubles) {
        this.doubles = doubles;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public Integer getSoloduel() {
        return soloduel;
    }

    public void setSoloduel(Integer soloduel) {
        this.soloduel = soloduel;
    }

    public String getGamertag() {
        return gamertag;
    }

    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

}