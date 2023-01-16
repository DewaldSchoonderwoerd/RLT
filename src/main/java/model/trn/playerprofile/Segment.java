
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Segment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("metadata")
    @Expose
    private Metadata__1 metadata;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("stats")
    @Expose
    private Stats stats;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Metadata__1 getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata__1 metadata) {
        this.metadata = metadata;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

}
