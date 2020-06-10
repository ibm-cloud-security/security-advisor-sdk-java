package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.PostGraphOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import java.io.ByteArrayInputStream;

public class PostGraph {

    private PostGraph() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        String body = "{notes{id}}";

        PostGraphOptions opts = new PostGraphOptions.Builder()
        .accountId("<accountId>")
        .body(new ByteArrayInputStream(body.getBytes()))
        .contentType("application/graphql")
        .build();

        Response<Void> resp = findingsApi.postGraph(opts).execute();
        System.out.println(resp.getResult());
    }
}
