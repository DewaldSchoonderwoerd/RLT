package api.airtable.models.getallrecords.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class GetAllRecordsResponse {

    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}