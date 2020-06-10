package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.BulkDeleteChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public final class DeleteBulkChannels {

    private DeleteBulkChannels() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        DeleteNotificationChannelsOptions opts = new DeleteNotificationChannelsOptions.Builder()
        .accountId("<accountId>")
        .body(new java.util.ArrayList<String>(java.util.Arrays.asList("id1", "id2")))
        .build();

        Response<BulkDeleteChannelsResponse> resp = notificationsApi.deleteNotificationChannels(opts).execute();
        System.out.println(resp.getResult());
    }
}
