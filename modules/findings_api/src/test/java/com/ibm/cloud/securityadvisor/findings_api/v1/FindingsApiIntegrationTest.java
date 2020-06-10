package com.ibm.cloud.securityadvisor.findings_api.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.*;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNote;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Card;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItem;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Context;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DataTransferred;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Finding;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.FindingCountValueType;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Kpi;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNotesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListProvidersOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.NetworkConnection;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CardElementsItemNumericCardElement;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.PostGraphOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.Reporter;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.SocketAddress;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.UpdateOccurrenceOptions;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import com.ibm.cloud.sdk.core.http.Response;
import org.testng.annotations.Test;

import org.powermock.modules.testng.PowerMockTestCase;

public class FindingsApiIntegrationTest extends PowerMockTestCase {
        public String ApiKey = System.getenv("API_KEY");
        public String AccountId = System.getenv("ACCOUNT_ID");
        public String IamUrl = System.getenv("IAM_URL");
        public String ApiUrl = System.getenv("FINDINGS_API_URL");

        public Authenticator authenticator = new IamAuthenticator(ApiKey, IamUrl, null, null, true, null);
        public FindingsApi findingsApi = new FindingsApi("findings_api", authenticator);

        @Test
        public void testPostGraph() throws Throwable {
                findingsApi.setServiceUrl(ApiUrl);
                PostGraphOptions opts = new PostGraphOptions.Builder().accountId(AccountId)
                                .contentType("application/graphql")
                                .body(new ByteArrayInputStream("{notes{id}}".getBytes())).build();

                Response<Void> resp = findingsApi.postGraph(opts).execute();
                assertNotNull(resp);
                assertEquals(resp.getStatusCode(), 200);
        }

        @Test
        public void testGetProviders() throws Throwable {
                findingsApi.setServiceUrl(ApiUrl);
                ListProvidersOptions opts = new ListProvidersOptions.Builder().accountId(AccountId).build();

                Response<ApiListProvidersResponse> resp = findingsApi.listProviders(opts).execute();
                assertNotNull(resp);
                assertEquals(resp.getStatusCode(), 200);
        }

        @Test
        public void testPostNote() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
                                        .kind("FINDING_COUNT")
                                        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays
                                                        .asList(AccountId + "/providers/test/notes/testNote")))
                                        .text("testString").build();

                        CardElementsItemNumericCardElement cardElementModel = new CardElementsItemNumericCardElement.Builder()
                                        .kind("NUMERIC").defaultTimeRange("1d").text("sample_text")
                                        .valueType(findingCountValueTypeModel).build();

                        ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder().label("testString")
                                        .url("https://cloud.ibm.com").build();

                        Card cardModel = new Card.Builder().section("testString").title("testString")
                                        .subtitle("testString")
                                        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays
                                                        .asList(AccountId + "/providers/test/notes/testNote")))
                                        .elements(new java.util.ArrayList<CardElementsItem>(
                                                        java.util.Arrays.asList(cardElementModel)))
                                        .build();

                        Reporter reporterModel = new Reporter.Builder().id("testString").title("testString")
                                        .url("testString").build();

                        KpiType kpiModel = new KpiType.Builder().aggregationType("SUM").build();

                        CreateNoteOptions createNoteOptionsModel = new CreateNoteOptions.Builder().accountId(AccountId)
                                        .providerId("test").shortDescription("testString").longDescription("testString")
                                        .kind("CARD").id("test1").reportedBy(reporterModel)
                                        .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(
                                                        java.util.Arrays.asList(apiNoteRelatedUrlModel)))
                                        .card(cardModel).kpi(kpiModel).build();

                        Response<ApiNote> resp = findingsApi.createNote(createNoteOptionsModel).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (ServiceResponseException e) {
                } finally {
                }

        }

        @Test
        public void testListNotes() throws Throwable {
                findingsApi.setServiceUrl(ApiUrl);

                ListNotesOptions opts = new ListNotesOptions.Builder().accountId(AccountId).providerId("test").build();

                Response<ApiListNotesResponse> resp = findingsApi.listNotes(opts).execute();
                assertNotNull(resp);
                assertEquals(resp.getStatusCode(), 200);
        }

        @Test
        public void testGetNote() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        GetNoteOptions opts = new GetNoteOptions.Builder().accountId(AccountId).providerId("test")
                                        .noteId("testString-card").build();

                        Response<ApiNote> resp = findingsApi.getNote(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }

        @Test
        public void testUpdateNote() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
                                        .kind("FINDING_COUNT")
                                        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays
                                                        .asList(AccountId + "/providers/test/notes/testNote")))
                                        .text("testString").build();

                        CardElementsItemNumericCardElement cardElementModel = new CardElementsItemNumericCardElement.Builder()
                                        .kind("NUMERIC").defaultTimeRange("1d").text("sample_text")
                                        .valueType(findingCountValueTypeModel).build();

                        ApiNoteRelatedUrl apiNoteRelatedUrlModel = new ApiNoteRelatedUrl.Builder().label("testString")
                                        .url("https://cloud.ibm.com").build();

                        Card cardModel = new Card.Builder().section("testString").title("testString")
                                        .subtitle("testString")
                                        .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays
                                                        .asList(AccountId + "/providers/test/notes/testNote")))
                                        .elements(new java.util.ArrayList<CardElementsItem>(
                                                        java.util.Arrays.asList(cardElementModel)))
                                        .build();

                        KpiType kpiModel = new KpiType.Builder().aggregationType("SUM").build();

                        Reporter reporterModel = new Reporter.Builder().id("testString").title("testString")
                                        .url("testString").build();

                        UpdateNoteOptions opts = new UpdateNoteOptions.Builder().noteId("koi-bhi-note")
                                        .accountId(AccountId).providerId("test").shortDescription("testString")
                                        .longDescription("testString").kind("CARD").id("test1")
                                        .reportedBy(reporterModel)
                                        .relatedUrl(new java.util.ArrayList<ApiNoteRelatedUrl>(
                                                        java.util.Arrays.asList(apiNoteRelatedUrlModel)))
                                        .kpi(kpiModel).card(cardModel).build();

                        Response<ApiNote> resp = findingsApi.updateNote(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (ServiceResponseException e) {
                } finally {
                }
        }

        @Test
        public void testDeleteNote() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        DeleteNoteOptions opts = new DeleteNoteOptions.Builder().accountId(AccountId).providerId("test")
                                        .noteId("test1").build();

                        Response<Void> resp = findingsApi.deleteNote(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (ServiceResponseException e) {
                } finally {
                }
        }

        @Test
        public void testGetNoteByOccurrenceId() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        GetOccurrenceNoteOptions opts = new GetOccurrenceNoteOptions.Builder().accountId(AccountId)
                                        .providerId("test").occurrenceId("testString-occurrence").build();

                        Response<ApiNote> resp = findingsApi.getOccurrenceNote(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }

        @Test
        public void testCreateOccurrence() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        SocketAddress socketAddressModel = new SocketAddress.Builder().address("testString")
                                        .port(Long.valueOf("26")).build();

                        DataTransferred dataTransferredModel = new DataTransferred.Builder()
                                        .clientBytes(Long.valueOf("26")).serverBytes(Long.valueOf("26"))
                                        .clientPackets(Long.valueOf("26")).serverPackets(Long.valueOf("26")).build();

                        NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
                                        .direction("testString").protocol("testString").client(socketAddressModel)
                                        .server(socketAddressModel).build();

                        RemediationStep remediationStepModel = new RemediationStep.Builder().title("testString")
                                        .url("testString").build();

                        Context contextModel = new Context.Builder().region("testString").resourceCrn("testString")
                                        .resourceId("testString").resourceName("testString").resourceType("testString")
                                        .serviceCrn("testString").serviceName("testString")
                                        .environmentName("testString").componentName("testString")
                                        .toolchainId("testString").build();

                        Finding findingModel = new Finding.Builder().severity("LOW").certainty("LOW")
                                        .nextSteps(new java.util.ArrayList<RemediationStep>(
                                                        java.util.Arrays.asList(remediationStepModel)))
                                        .networkConnection(networkConnectionModel).dataTransferred(dataTransferredModel)
                                        .build();

                        Kpi kpiModel = new Kpi.Builder().value(Double.valueOf("72.5")).total(Double.valueOf("72.5"))
                                        .build();

                        CreateOccurrenceOptions createOccurrenceOptionsModel = new CreateOccurrenceOptions.Builder()
                                        .accountId(AccountId).providerId("test")
                                        .noteName(AccountId + "/providers" + "/test/notes/" + "test").kind("FINDING")
                                        .id("testString").resourceUrl("testString").remediation("testString")
                                        .context(contextModel).finding(findingModel).kpi(kpiModel).replaceIfExists(true)
                                        .build();

                        Response<ApiOccurrence> resp = findingsApi.createOccurrence(createOccurrenceOptionsModel)
                                        .execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }

        @Test
        public void testListOccurrences() throws Throwable {
                findingsApi.setServiceUrl(ApiUrl);

                ListOccurrencesOptions opts = new ListOccurrencesOptions.Builder().accountId(AccountId)
                                .providerId("test").build();

                Response<ApiListOccurrencesResponse> resp = findingsApi.listOccurrences(opts).execute();
                assertNotNull(resp);
                assertEquals(resp.getStatusCode(), 200);
        }

        @Test
        public void testGetOccurrence() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        GetOccurrenceOptions opts = new GetOccurrenceOptions.Builder().accountId(AccountId)
                                        .providerId("test").occurrenceId("testString-occurrence").build();

                        Response<ApiListOccurrencesResponse> resp = findingsApi.getOccurrence(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }

        @Test
        public void testUpdateOccurrence() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        SocketAddress socketAddressModel = new SocketAddress.Builder().address("testString")
                                        .port(Long.valueOf("26")).build();

                        DataTransferred dataTransferredModel = new DataTransferred.Builder()
                                        .clientBytes(Long.valueOf("26")).serverBytes(Long.valueOf("26"))
                                        .clientPackets(Long.valueOf("26")).serverPackets(Long.valueOf("26")).build();

                        NetworkConnection networkConnectionModel = new NetworkConnection.Builder()
                                        .direction("testString").protocol("testString").client(socketAddressModel)
                                        .server(socketAddressModel).build();

                        RemediationStep remediationStepModel = new RemediationStep.Builder().title("testString")
                                        .url("testString").build();

                        Context contextModel = new Context.Builder().region("testString").resourceCrn("testString")
                                        .resourceId("testString").resourceName("testString").resourceType("testString")
                                        .serviceCrn("testString").serviceName("testString")
                                        .environmentName("testString").componentName("testString")
                                        .toolchainId("testString").build();

                        Finding findingModel = new Finding.Builder().severity("LOW").certainty("LOW")
                                        .nextSteps(new java.util.ArrayList<RemediationStep>(
                                                        java.util.Arrays.asList(remediationStepModel)))
                                        .networkConnection(networkConnectionModel).dataTransferred(dataTransferredModel)
                                        .build();

                        Kpi kpiModel = new Kpi.Builder().value(Double.valueOf("72.5")).total(Double.valueOf("72.5"))
                                        .build();

                        UpdateOccurrenceOptions updateOccurrenceOptionsModel = new UpdateOccurrenceOptions.Builder()
                                        .accountId(AccountId).providerId("test")
                                        .noteName(AccountId + "/providers" + "/test/notes/" + "test").kind("FINDING")
                                        .id("testString").resourceUrl("testString").remediation("testString")
                                        .context(contextModel).finding(findingModel).kpi(kpiModel)
                                        .occurrenceId("testString-occurrence").build();

                        Response<ApiOccurrence> resp = findingsApi.updateOccurrence(updateOccurrenceOptionsModel)
                                        .execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }

        @Test
        public void testDeleteOccurrence() throws Throwable {
                try {
                        findingsApi.setServiceUrl(ApiUrl);

                        DeleteOccurrenceOptions opts = new DeleteOccurrenceOptions.Builder().accountId(AccountId)
                                        .providerId("test").occurrenceId("testString-occurrence").build();

                        Response<Void> resp = findingsApi.deleteOccurrence(opts).execute();
                        assertNotNull(resp);
                        assertEquals(resp.getStatusCode(), 200);
                } catch (NotFoundException e) {
                } finally {
                }
        }
}
