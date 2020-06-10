package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNote;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Reporter;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Section;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateNoteOptions;

public class CreateNoteWithSection {

    private CreateNoteWithSection() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        Reporter reporterModel = new Reporter.Builder()
            .id("testString")
            .title("testString")
            .url("testString")
            .build();

        Section section = new Section.Builder()
            .image("testString")
            .title("testString")
            .build();

        CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
            .accountId("<accountId>")
            .providerId("test")
            .shortDescription("testString")
            .longDescription("testString")
            .kind("KPI")
            .id("test1")
            .reportedBy(reporterModel)
            .section(section)
            .build();

        Response<ApiNote> resp = findingsApi.createNote(createNoteOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}
