
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attributes__1 {

    @SerializedName("season")
    @Expose
    private Integer season;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

}
