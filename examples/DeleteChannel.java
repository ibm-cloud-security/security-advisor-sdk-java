package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public final class DeleteChannel {

    private DeleteChannel() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        DeleteNotificationChannelOptions opts = new DeleteNotificationChannelOptions.Builder()
        .accountId("<accountId>")
        .channelId("<channelId>")
        .build();

        Response<DeleteChannelResponse> resp = notificationsApi.deleteNotificationChannel(opts).execute();
        System.out.println(resp.getResult());
    }
}
