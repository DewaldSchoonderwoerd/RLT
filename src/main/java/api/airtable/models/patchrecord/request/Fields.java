package api.airtable.models.patchrecord.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("discord")
    @Expose
    private String discord;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("gamertag")
    @Expose
    private String gamertag;
    @SerializedName("soloduel")
    @Expose
    private Integer soloduel;
    @SerializedName("doubles")
    @Expose
    private Integer doubles;
    @SerializedName("standard")
    @Expose
    private Integer standard;
    @SerializedName("average")
    @Expose
    private Integer average;

    public String getDiscord() {
        return discord;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGamertag() {
        return gamertag;
    }

    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    public Integer getSoloduel() {
        return soloduel;
    }

    public void setSoloduel(Integer soloduel) {
        this.soloduel = soloduel;
    }

    public Integer getDoubles() {
        return doubles;
    }

    public void setDoubles(Integer doubles) {
        this.doubles = doubles;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

}