package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItem;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItemNumericCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.FindingCountValueType;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Card;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Reporter;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNote;

public class CreateCard {

    private CreateCard() { }

    public static void main(String[] args) {

        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);
        findingsApi.setServiceUrl("<apiUrl>");

        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
            .kind("FINDING_COUNT")
            .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("<noteName>")))
            .text("testString")
            .build();

        CardElementsItemNumericCardElement cardElementModel = new CardElementsItemNumericCardElement.Builder()
            .kind("NUMERIC")
            .defaultTimeRange("1d")
            .text("sample_text")
            .valueType(findingCountValueTypeModel)
            .build();

        ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder()
            .label("testString")
            .url("https://cloud.ibm.com")
            .build();

        Card cardModel = new Card.Builder()
            .section("testString")
            .title("testString")
            .subtitle("testString")
            .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("noteName")))
            .elements(new java.util.ArrayList<CardElementsItem>(java.util.Arrays.asList(cardElementModel)))
            .build();

        Reporter reporterModel = new Reporter.Builder()
            .id("testString")
            .title("testString")
            .url("https://cloud.ibm.com")
            .build();

        CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder()
            .accountId("<accountId>")
            .providerId("test")
            .shortDescription("testString")
            .longDescription("testString")
            .kind("CARD")
            .id("test1")
            .reportedBy(reporterModel)
            .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(java.util.Arrays.asList(apiNoteRelatedUrlModel)))
            .card(cardModel)
            .build();

        Response<ApiNote> resp = findingsApi.createNote(createNoteOptionsModel).execute();
        System.out.println(resp.getResult());
    }
}
