package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Kpi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiOccurrence;

public class CreateOccurrenceWithKPI {

    private CreateOccurrenceWithKPI() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        Kpi kpiModel = new Kpi.Builder()
            .total(Double.valueOf("100"))
            .value(Double.valueOf("10"))
            .build();

        CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
            .accountId("<accountId>")
            .providerId("test")
            .noteName("<accountId>" + "/providers" + "/test/notes/" + "example")
            .kind("KPI")
            .id("testString")
            .kpi(kpiModel)
            .replaceIfExists(true)
            .build();

        Response<ApiOccurrence> resp = findingsApi.createOccurrence(createOccurrenceOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}
