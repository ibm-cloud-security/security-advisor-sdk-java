package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNoteOccurrencesResponse;

public class ListNoteOccurrences {

    private ListNoteOccurrences() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        ListNoteOccurrencesOptions opts = new ListNoteOccurrencesOptions.Builder()
        .accountId("<accountId>")
        .providerId("<providerId>")
        .noteId("<noteId>")
        .build();

        Response<ApiListNoteOccurrencesResponse> resp = findingsApi.listNoteOccurrences(opts).execute();
        System.out.println(resp.getResult());
    }
}
