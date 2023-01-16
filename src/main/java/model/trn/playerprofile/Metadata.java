
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Metadata {

    @SerializedName("lastUpdated")
    @Expose
    private LastUpdated lastUpdated;
    @SerializedName("playerId")
    @Expose
    private Integer playerId;
    @SerializedName("currentSeason")
    @Expose
    private Integer currentSeason;

    public LastUpdated getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LastUpdated lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Integer currentSeason) {
        this.currentSeason = currentSeason;
    }

}
