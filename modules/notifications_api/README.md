# Notifications API

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.cloud.securityadvisor</groupId>
  <artifactId>notifications_api</artifactId>
  <version>1.0.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.cloud.securityadvisor:notifications_api:1.0.0'
```

## Usage

Use the [Notifications API][notifications_api] service to create notification channels and more.

```java
package com.ibm.cloud.securityadvisor.notifications_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.notifications_api.v1.*;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.*;
import com.ibm.cloud.sdk.core.security.*;

public class listChannels {

    public static String getEnvVar(String var, String defValue) {
        String value = System.getenv(var);
        return value!=null?value:defValue;
    }

    public static void main(String[] args){
        String apiKey = getEnvVar("API_KEY", "");
        String accountId = getEnvVar("ACCOUNT_ID", "");
        String apiUrl = getEnvVar("API_URL", "https://us-south.secadvisor.test.cloud.ibm.com/notifications");
        String iamUrl = getEnvVar("IAM_URL", "https://iam.test.cloud.ibm.com/identity/token");
        
        Authenticator authenticator = new IamAuthenticator(apiKey, iamUrl, null, null, true, null);

        NotificationsApi notifications_api = new NotificationsApi("notifications_api", authenticator);
        notifications_api.setServiceUrl(apiUrl);

        ListAllChannelsOptions opts = new ListAllChannelsOptions.Builder()
        .accountId(accountId)
        .build();

        Response<ListChannelsResponse> resp = notifications_api.listAllChannels(opts).execute();
        System.out.println(resp.getStatusCode()+" "+resp.getStatusMessage());
        System.out.println(resp.getResult());
    }
}
```