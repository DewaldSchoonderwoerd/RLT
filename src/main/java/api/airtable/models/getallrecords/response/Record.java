package api.airtable.models.getallrecords.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Record {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdTime")
    @Expose
    private String createdTime;
    @SerializedName("fields")
    @Expose
    private Fields fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

}