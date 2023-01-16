package api.airtable.resource.airtableapi;

import api.airtable.models.getallrecords.response.GetAllRecordsResponse;
import api.airtable.models.patchrecord.request.PatchRecordRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
public interface AirTableApiResource {

    @GET
    GetAllRecordsResponse getAllRecords(
            @QueryParam("view") String stateCode,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String bearerToken
    );

    @PATCH
    @Path("/")
    Response updateRecords(
            @HeaderParam(HttpHeaders.AUTHORIZATION) String bearerToken,
            PatchRecordRequest patchRecordRequest
            );
}
