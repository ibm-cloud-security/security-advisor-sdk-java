package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public final class TestChannel {

    private TestChannel() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        TestNotificationChannelOptions opts = new TestNotificationChannelOptions.Builder()
        .accountId("<accountId>")
        .channelId("<channelId>")
        .build();

        Response<TestChannelResponse> resp = notificationsApi.testNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
