# Findings API

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.cloud.securityadvisor</groupId>
  <artifactId>findings_api</artifactId>
  <version>1.1.3</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.cloud.securityadvisor:findings_api:1.1.3'
```

## Usage

Use the [Findings API][findings_api] service to create findings, occurrences and more.

```java
package com.ibm.cloud.securityadvisor.findings_api.v1.examples;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.securityadvisor.findings_api.v1.*;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.*;
import com.ibm.cloud.sdk.core.security.*;
import java.io.*;

public class postGraph {

    public static String getEnvVar(String var, String defValue) {
        String value = System.getenv(var);
        return value!=null?value:defValue;
    }

    public static void main(String[] args) {
        String apiKey = getEnvVar("API_KEY", "");
        String accountId = getEnvVar("ACCOUNT_ID", "");
        String apiUrl = getEnvVar("API_URL", "https://us-south.secadvisor.test.cloud.ibm.com/findings");
        String iamUrl = getEnvVar("IAM_URL", "https://iam.test.cloud.ibm.com/identity/token");
        String body = getEnvVar("BODY", "{notes{id}}");
        
        Authenticator authenticator = new IamAuthenticator(apiKey, iamUrl, null, null, true, null);

        FindingsApi findings_api = new FindingsApi("findings_api", authenticator);
        findings_api.setServiceUrl(apiUrl);
        
        PostGraphOptions opts = new PostGraphOptions.Builder()
        .accountId(accountId)
        .body(new ByteArrayInputStream(body.getBytes()))
        .contentType("application/graphql")
        .build();
        
        Response<Void> resp = findings_api.postGraph(opts).execute();
        System.out.println(resp.getStatusCode()+" "+resp.getStatusMessage());
    }

}
```