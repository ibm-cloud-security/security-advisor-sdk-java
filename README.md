[![Build Status](https://api.travis-ci.org/ibm-cloud-security/security-advisor-sdk-java.svg?branch=master)](https://travis-ci.org/github/ibm-cloud-security/security-advisor-sdk-java)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

# IBM Cloud Security Advisor Java SDK Version 2.0.1
Java client library to interact with various [IBM Cloud Security Advisor](https://cloud.ibm.com/apidocs?category=security).

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

## Table of Contents

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc --maxdepth 4 -i README.md
  -->

<!-- toc -->

- [IBM Cloud Security Advisor Java SDK Version 2.0.1](#ibm-cloud-security-advisor-java-sdk-version-116)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
        - [Maven](#maven)
        - [Gradle](#gradle)
  - [Authentication](#authentication)
    - [Authenticating using the IAM API key:](#authenticating-using-the-iam-api-key)
    - [Authenticating using the IAM Token:](#authenticating-using-the-iam-token)
  - [Using the SDK](#using-the-sdk)
  - [Questions](#questions)
  - [Issues](#issues)
  - [Open source @ IBM](#open-source--ibm)
  - [Contributing](#contributing)
  - [License](#license)

<!-- tocstop -->

## Overview

The IBM Cloud Security Advisor Java SDK allows developers to programmatically interact with the following IBM Cloud services:

Service Name | Artifact Coordinates
--- | --- 
[IBM Cloud Security Advisor Findings API](https://cloud.ibm.com/apidocs/findings) | com.ibm.cloud.securityadvisor:findings_api:2.0.1
[IBM Cloud Security Advisor Notifications API](https://cloud.ibm.com/apidocs/security-compliance/si-notifications) | com.ibm.cloud.securityadvisor:notifications_api:2.0.1

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 2.0.1

Each service's artifact coordinates are listed in the table above.

To use a particular service, define a dependency that contains the
artifact coordinates (group id, artifact id and version) for the service, like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>securityadvisor</artifactId>
    <version>2.0.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.cloud:securityadvisor:2.0.1'
```

## Authentication
IBM Cloud Security Advisor uses token-based [Identity and Access Management (IAM) authentication](https://cloud.ibm.com/docs/iam?topic=iam-getstarted).

IAM authentication uses a service API key to get an access token that is passed with the call. Access tokens are valid for a limited amount of time and must be regenerated.

To provide credentials to the SDK, you supply either an IAM service **API key** or an **access token**:

- Use the API key to have the SDK manage the lifecycle of the access token. The SDK requests an access token, ensures that the access token is valid, and refreshes it if necessary.
- Use the access token if you want to manage the lifecycle yourself. For details, check `Authenticating using the IAM Token` section.

### Authenticating using the IAM API key:

```java
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;

IamAuthenticator authenticator = new IamAuthenticator("<apiKey>");
NotificationsApi notificationsApi = new NotificationsApi("notifications_api", authenticator); //Initialize notifications service
FindingsApi findingsApi = new FindingsApi("findings_api", authenticator); //Initialize findings service
```

### Authenticating using the IAM Token:

```java
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.BearerTokenAuthenticator;
import com.ibm.cloud.securityadvisor.notifications_api.v1.NotificationsApi;
import com.ibm.cloud.securityadvisor.findings_api.v1.FindingsApi;

IamAuthenticator authenticator = new IamAuthenticator("<apiKey>");
IamToken iamToken = authenticator.requestToken(); //Generating the token
String token = iamToken.getAccessToken(); // Getting the token

BearerTokenAuthenticator bearerAuth = new BearerTokenAuthenticator(token); // initialize BearerTokenAuthenticator
NotificationsApi notificationsApi = new NotificationsApi("notifications_api", bearerAuth);//Initialize notifications service
FindingsApi findingsApi = new FindingsApi("findings_api", bearerAuth); //Initialize findings service
```


## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)

For Findings API module usage information of the SDK, please see [this link](https://github.com/ibm-cloud-security/security-advisor-sdk-java/tree/master/modules/findings_api)

For Notifications API module usage information of the SDK, please see [this link](https://github.com/ibm-cloud-security/security-advisor-sdk-java/tree/master/modules/notifications_api)


## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/ibm-cloud-security/security-advisor-sdk-java/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud Security Advisor Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
