
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Metadata__10 {

    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("rankName")
    @Expose
    private String rankName;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

}
