package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateChannelResponse;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public class UpdateChannel {

    private UpdateChannel() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
        .providerName("testString")
        .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .build();

        UpdateNotificationChannelOptions opts = new UpdateNotificationChannelOptions.Builder()
        .channelId("<channelId>")
        .name("testString")
        .description("testString")
        .type("Webhook")
        .endpoint("http://test.com")
        .enabled(true)
        .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
        .accountId("<accountId>")
        .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
        .build();

        Response<UpdateChannelResponse> resp = notificationsApi.updateNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
