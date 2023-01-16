
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Metadata__14 {

    @SerializedName("deltaDown")
    @Expose
    private Integer deltaDown;
    @SerializedName("deltaUp")
    @Expose
    private Integer deltaUp;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getDeltaDown() {
        return deltaDown;
    }

    public void setDeltaDown(Integer deltaDown) {
        this.deltaDown = deltaDown;
    }

    public Integer getDeltaUp() {
        return deltaUp;
    }

    public void setDeltaUp(Integer deltaUp) {
        this.deltaUp = deltaUp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
