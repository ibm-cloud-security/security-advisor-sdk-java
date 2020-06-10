package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListProvidersOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListProvidersResponse;

public class ListProviders {

    private ListProviders() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        ListProvidersOptions opts = new ListProvidersOptions.Builder()
        .accountId("<accountId>")
        .build();

        Response<ApiListProvidersResponse> resp = findingsApi.listProviders(opts).execute();
        System.out.println(resp.getResult());
    }
}
