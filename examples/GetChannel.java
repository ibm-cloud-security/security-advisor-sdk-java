package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public final class GetChannel {

    private GetChannel() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        GetNotificationChannelOptions opts = new GetNotificationChannelOptions.Builder()
        .accountId("<accountId>")
        .channelId("<channelId>")
        .build();

        Response<GetChannelResponse> resp = notificationsApi.getNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
