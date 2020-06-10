package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Finding;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Context;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.RemediationStep;

public class CreateOccurrenceWithContext {

    private CreateOccurrenceWithContext() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        RemediationStep remediationStepModel = new RemediationStep.Builder()
            .title("testString")
            .url("https://cloud.ibm.com")
            .build();

        Finding findingModel = new Finding.Builder()
            .severity("LOW")
            .certainty("LOW")
            .nextSteps(new java.util.ArrayList<RemediationStep>(java.util.Arrays.asList(remediationStepModel)))
            .build();

        Context contextModel = new Context.Builder()
            .region("testString")
            .resourceCrn("testString")
            .resourceId("testString")
            .resourceName("testString")
            .resourceType("testString")
            .serviceCrn("testString")
            .serviceName("testString")
            .environmentName("testString")
            .componentName("testString")
            .toolchainId("testString")
            .build();

        CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
            .accountId("<accountId>")
            .providerId("test")
            .noteName("<accountId>" + "/providers" + "/test/notes/" + "example")
            .kind("FINDING")
            .id("testString")
            .resourceUrl("https://cloud.ibm.com")
            .remediation("testString")
            .finding(findingModel)
            .replaceIfExists(true)
            .context(contextModel)
            .build();

        Response<ApiOccurrence> resp = findingsApi.createOccurrence(createOccurrenceOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}
