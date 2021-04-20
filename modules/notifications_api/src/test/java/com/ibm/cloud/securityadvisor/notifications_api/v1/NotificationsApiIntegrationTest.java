package com.ibm.cloud.securityadvisor.notifications_api.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelDelete;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelGet;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelInfo;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelsDelete;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ChannelsList;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.PublicKeyGet;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestChannel;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateNotificationChannelOptions;

import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

public class NotificationsApiIntegrationTest extends PowerMockTestCase {

    public String ApiKey = System.getenv("API_KEY");
    public String AccountId = System.getenv("ACCOUNT_ID");
    public String IamUrl = System.getenv("IAM_URL");
    public String ApiUrl = System.getenv("NOTIFICATIONS_API_URL");
    public Authenticator authenticator = new IamAuthenticator(ApiKey, IamUrl, null, null, true, null);
    public NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
    String channelId = "testString";

    @Test
    public void testListChannels() throws Throwable {
        notificationsApi.setServiceUrl(ApiUrl);
        ListAllChannelsOptions opts = new ListAllChannelsOptions.Builder().accountId(AccountId).build();

        Response<ChannelsList> resp = notificationsApi.listAllChannels(opts).execute();

        assertNotNull(resp);
        assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    public void testChannelCreate() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
                    .providerName("CERT")
                    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("ALL"))).build();

            CreateNotificationChannelOptions createNotificationChannelOptionsModel = new CreateNotificationChannelOptions.Builder()
                    .accountId(AccountId).name("testString").type("Webhook").endpoint("https://webhook.site/e36d188b-1e74-42c1-b69a-9a33423d39f3")
                    .description("testString").severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low", "critical")))
                    .enabled(true).alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(
                            java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
                    .build();

            Response<ChannelInfo> resp = notificationsApi
                    .createNotificationChannel(createNotificationChannelOptionsModel).execute();
            channelId = resp.getResult().getChannelId();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (NotFoundException e) {
        } finally {
        }
    }

    @Test
    public void testChannelUpdate() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
                    .providerName("ATA")
                    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("ALL"))).build();

            UpdateNotificationChannelOptions opts = new UpdateNotificationChannelOptions.Builder().accountId(AccountId)
                    .name("testString").type("Webhook").endpoint("https://webhook.site/e36d188b-1e74-42c1-b69a-9a33423d39f3").description("testString")
                    .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low"))).enabled(true)
                    .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(
                            java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
                    .channelId(channelId).build();

            Response<ChannelInfo> resp = notificationsApi.updateNotificationChannel(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (NotFoundException e) {
        } finally {
        }
    }

    @Test
    public void testChannelGet() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            GetNotificationChannelOptions opts = new GetNotificationChannelOptions.Builder().accountId(AccountId)
                    .channelId(channelId).build();

            Response<ChannelGet> resp = notificationsApi.getNotificationChannel(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (NotFoundException e) {
        } finally {
        }
    }

    @Test
    public void testConnectionTest() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            TestNotificationChannelOptions opts = new TestNotificationChannelOptions.Builder().accountId(AccountId)
                    .channelId(channelId).build();

            Response<TestChannel> resp = notificationsApi.testNotificationChannel(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (InternalServerErrorException e) {
        } finally {
        }
    }

    @Test
    public void testDeleteChannels() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            List<String> channelsList = new ArrayList<String>();
            channelsList.add(channelId);

            DeleteNotificationChannelsOptions opts = new DeleteNotificationChannelsOptions.Builder()
                    .accountId(AccountId).body(channelsList).build();

            Response<ChannelsDelete> resp = notificationsApi.deleteNotificationChannels(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (InternalServerErrorException e) {
        } finally {
        }
    }

    @Test
    public void testDeleteChannel() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            DeleteNotificationChannelOptions opts = new DeleteNotificationChannelOptions.Builder().accountId(AccountId)
                    .channelId("testString").build();

            Response<ChannelDelete> resp = notificationsApi.deleteNotificationChannel(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (InternalServerErrorException | NotFoundException e) {
        } finally {
        }
    }

    @Test
    public void testGetPublicKey() throws Throwable {
        try {
            notificationsApi.setServiceUrl(ApiUrl);

            GetPublicKeyOptions opts = new GetPublicKeyOptions.Builder().accountId(AccountId).build();

            Response<PublicKeyGet> resp = notificationsApi.getPublicKey(opts).execute();
            assertNotNull(resp);
            assertEquals(resp.getStatusCode(), 200);
        } catch (InternalServerErrorException | NotFoundException e) {
        } finally {
        }
    }

}