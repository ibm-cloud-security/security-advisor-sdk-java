package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteOccurrenceOptions;

public class DeleteOccurrence {

    private DeleteOccurrence() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        DeleteOccurrenceOptions opts = new DeleteOccurrenceOptions.Builder()
            .accountId("<accountId>")
            .providerId("<providerId>")
            .occurrenceId("<occurrenceId>")
            .build();

        Response<Void> resp = findingsApi.deleteOccurrence(opts).execute();
        System.out.println(resp.getResult());
    }
}
