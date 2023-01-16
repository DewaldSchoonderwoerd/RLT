package test;

import api.airtable.models.getallrecords.response.GetAllRecordsResponse;
import api.airtable.models.getallrecords.response.Record;
import api.airtable.models.patchrecord.request.Fields;
import api.airtable.models.patchrecord.request.PatchRecordRequest;
import api.client.JaxRsBase;
import base.Base;
import base.web.pom.RLTProfilePage;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import model.member.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewNewNew extends Base {

    private static final Logger LOG = LoggerFactory.getLogger(NewNewNew.class);
    private static final JaxRsBase jaxRsClient = JaxRsBase.getInstance();
    private RLTProfilePage rltProfilePage;
    private static final List<Member> memberList = new ArrayList<>();

    private final String token = "Bearer ";

    @BeforeClass(alwaysRun = true)
    private void setup() {
        rltProfilePage = new RLTProfilePage(driver);
    }

    @Test
    public void pullSomeStuffs(){
        // Get all records
        GetAllRecordsResponse getAllRecordsResponse = jaxRsClient.getAirTableResource().getAllRecords("Record", token);

        // Loop for each record
        for (Record currentRecord : getAllRecordsResponse.getRecords()) {

            // Check member
            if (currentRecord.getFields().getGamertag() == null || currentRecord.getFields().getPlatform() == null){
                LOG.error("Not a valid member");
                Assert.fail();
            }

            LOG.info("Fetch MMR for: " + currentRecord.getFields().getGamertag() + " - " + currentRecord.getFields().getPlatform());

            rltProfilePage.newPullMmr(currentRecord);
            setAgg(currentRecord);

            PatchRecordRequest patchRecordRequest = new PatchRecordRequest();
            List<api.airtable.models.patchrecord.request.Record> recordList = new ArrayList<>();
            patchRecordRequest.setRecords(recordList);

            api.airtable.models.patchrecord.request.Record record = new api.airtable.models.patchrecord.request.Record();
            Fields fields = new Fields();
            fields.setSoloduel(currentRecord.getFields().getSoloduel());
            fields.setDoubles(currentRecord.getFields().getDoubles());
            fields.setStandard(currentRecord.getFields().getStandard());
            fields.setGamertag(currentRecord.getFields().getGamertag());
            fields.setPlatform(currentRecord.getFields().getPlatform());
            fields.setDiscord(currentRecord.getFields().getDiscord());
            fields.setAverage(currentRecord.getFields().getAverage());
            record.setFields(fields);
            record.setId(currentRecord.getId());
            recordList.add(record);

            patchRecordRequest.setRecords(recordList);
            updateRecordToAirTable(patchRecordRequest);
        }
    }

    public void setAgg(Record record){
        int[] tab = {
                record.getFields().getSoloduel(),
                record.getFields().getDoubles(),
                record.getFields().getStandard()
        };

        int average = 0;
        if (Arrays.stream(tab).average().isPresent())
            average = (int) Arrays.stream(tab).average().getAsDouble();
        record.getFields().setAverage(average);
    }

    private void updateRecordToAirTable(PatchRecordRequest patchRecordRequest){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(patchRecordRequest));
        Request request = new Request.Builder()
                .url("https://api.airtable.com/v0/appw0vHbBDreHfAjt/leaderboard")
                .method("PATCH", body)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().toString();
            Assert.assertEquals(response.code(), 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
