package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.PublicKeyResponse;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.Authenticator;

public final class GetPublicKey {

    private GetPublicKey() { }

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("<apiKey>");

        NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator);
        notificationsApi.setServiceUrl("<apiUrl>");

        GetPublicKeyOptions opts = new GetPublicKeyOptions.Builder()
        .accountId("<accountId>")
        .build();

        Response<PublicKeyResponse> resp = notificationsApi.getPublicKey(opts).execute();
        System.out.println(resp.getResult());
    }
}
