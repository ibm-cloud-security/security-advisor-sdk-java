package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNotesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNotesResponse;

public class ListNotes {

    private ListNotes() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        ListNotesOptions opts = new ListNotesOptions.Builder()
        .accountId("<accountId>")
        .providerId("<providerId>")
        .build();

        Response<ApiListNotesResponse> resp = findingsApi.listNotes(opts).execute();
        System.out.println(resp.getResult());
    }
}
