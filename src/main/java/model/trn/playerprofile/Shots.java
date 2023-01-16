
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Shots {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("percentile")
    @Expose
    private Double percentile;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("displayCategory")
    @Expose
    private String displayCategory;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("metadata")
    @Expose
    private Metadata__7 metadata;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("displayValue")
    @Expose
    private String displayValue;
    @SerializedName("displayType")
    @Expose
    private String displayType;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getPercentile() {
        return percentile;
    }

    public void setPercentile(Double percentile) {
        this.percentile = percentile;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayCategory() {
        return displayCategory;
    }

    public void setDisplayCategory(String displayCategory) {
        this.displayCategory = displayCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Metadata__7 getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata__7 metadata) {
        this.metadata = metadata;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

}
