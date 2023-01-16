
package model.trn.playerprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AvailableSegment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("attributes")
    @Expose
    private Attributes__1 attributes;
    @SerializedName("metadata")
    @Expose
    private Metadata__18 metadata;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attributes__1 getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes__1 attributes) {
        this.attributes = attributes;
    }

    public Metadata__18 getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata__18 metadata) {
        this.metadata = metadata;
    }

}
