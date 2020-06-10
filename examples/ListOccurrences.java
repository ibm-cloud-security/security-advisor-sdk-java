package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListOccurrencesResponse;

public class ListOccurrences {

    private ListOccurrences() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        ListOccurrencesOptions opts = new ListOccurrencesOptions.Builder()
        .accountId("<accountId>")
        .providerId("<providerId>")
        .build();

        Response<ApiListOccurrencesResponse> resp = findingsApi.listOccurrences(opts).execute();
        System.out.println(resp.getResult());
    }
}
