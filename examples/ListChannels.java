package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListChannelsResponse;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public class ListChannels {

    private ListChannels() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        ListAllChannelsOptions opts = new ListAllChannelsOptions.Builder()
        .accountId("<accountId>")
        .build();

        Response<ListChannelsResponse> resp = notificationsApi.listAllChannels(opts).execute();
        System.out.println(resp.getResult());
    }
}
