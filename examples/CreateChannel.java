package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateChannelsResponse;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public class CreateChannel {

    private CreateChannel() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
        .providerName("testString")
        .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .build();

        CreateNotificationChannelOptions opts = new CreateNotificationChannelOptions.Builder()
        .name("testString")
        .description("testString")
        .type("Webhook")
        .endpoint("http://test.com")
        .enabled(true)
        .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
        .accountId("<accountId>")
        .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
        .build();

        Response<CreateChannelsResponse> resp = notificationsApi.createNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
