/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.securityadvisor.notifications_api.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import com.ibm.cloud.sdk.core.util.EnvironmentUtils;

import com.ibm.cloud.securityadvisor.notifications_api.v1.model.BulkDeleteChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.CreateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.DeleteNotificationChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.GetPublicKeyOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListAllChannelsOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.ListChannelsResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.NotificationChannelAlertSourceItem;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.PublicKeyResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.TestNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateChannelResponse;
import com.ibm.cloud.securityadvisor.notifications_api.v1.model.UpdateNotificationChannelOptions;
import com.ibm.cloud.securityadvisor.notifications_api.v1.utils.TestUtilities;
import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the NotificationsApi service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class NotificationsApiTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected NotificationsApi testService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    testService = NotificationsApi.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new NotificationsApi(serviceName, null);
  }

  @Test
  public void testListAllChannelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channels\": [{\"channel_id\": \"channelId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"Webhook\", \"severity\": {\"high\": true, \"medium\": true, \"low\": false}, \"endpoint\": \"endpoint\", \"enabled\": false, \"alertSource\": [{\"provider_name\": \"providerName\", \"finding_types\": [\"findingTypes\"]}], \"frequency\": \"frequency\"}]}";
    String listAllChannelsPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAllChannelsOptions model
    ListAllChannelsOptions listAllChannelsOptionsModel = new ListAllChannelsOptions.Builder()
    .accountId("testString")
    .limit(Long.valueOf("26"))
    .skip(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListChannelsResponse> response = testService.listAllChannels(listAllChannelsOptionsModel).execute();
    assertNotNull(response);
    ListChannelsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("skip")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAllChannelsPath);
  }

  // Test the listAllChannels operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAllChannelsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listAllChannels(null).execute();
  }

  @Test
  public void testCreateNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"statusCode\": 10}";
    String createNotificationChannelPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the NotificationChannelAlertSourceItem model
    NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
    .providerName("testString")
    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CreateNotificationChannelOptions model
    CreateNotificationChannelOptions createNotificationChannelOptionsModel = new CreateNotificationChannelOptions.Builder()
    .accountId("testString")
    .name("testString")
    .type("Webhook")
    .endpoint("testString")
    .description("testString")
    .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
    .enabled(true)
    .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateChannelsResponse> response = testService.createNotificationChannel(createNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    CreateChannelsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createNotificationChannelPath);
  }

  // Test the createNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createNotificationChannel(null).execute();
  }

  @Test
  public void testDeleteNotificationChannelsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"message\": \"message\"}";
    String deleteNotificationChannelsPath = "/v1/testString/notifications/channels";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteNotificationChannelsOptions model
    DeleteNotificationChannelsOptions deleteNotificationChannelsOptionsModel = new DeleteNotificationChannelsOptions.Builder()
    .accountId("testString")
    .body(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<BulkDeleteChannelsResponse> response = testService.deleteNotificationChannels(deleteNotificationChannelsOptionsModel).execute();
    assertNotNull(response);
    BulkDeleteChannelsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationChannelsPath);
  }

  // Test the deleteNotificationChannels operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationChannelsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteNotificationChannels(null).execute();
  }

  @Test
  public void testDeleteNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"message\": \"message\"}";
    String deleteNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteNotificationChannelOptions model
    DeleteNotificationChannelOptions deleteNotificationChannelOptionsModel = new DeleteNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteChannelResponse> response = testService.deleteNotificationChannel(deleteNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    DeleteChannelResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationChannelPath);
  }

  // Test the deleteNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteNotificationChannel(null).execute();
  }

  @Test
  public void testGetNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel\": {\"channel_id\": \"channelId\", \"name\": \"name\", \"description\": \"description\", \"type\": \"Webhook\", \"severity\": {\"high\": true, \"medium\": true, \"low\": false}, \"endpoint\": \"endpoint\", \"enabled\": false, \"alertSource\": [{\"provider_name\": \"providerName\", \"finding_types\": [\"findingTypes\"]}], \"frequency\": \"frequency\"}}";
    String getNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetNotificationChannelOptions model
    GetNotificationChannelOptions getNotificationChannelOptionsModel = new GetNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GetChannelResponse> response = testService.getNotificationChannel(getNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    GetChannelResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getNotificationChannelPath);
  }

  // Test the getNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getNotificationChannel(null).execute();
  }

  @Test
  public void testUpdateNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"channel_id\": \"channelId\", \"statusCode\": 10}";
    String updateNotificationChannelPath = "/v1/testString/notifications/channels/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the NotificationChannelAlertSourceItem model
    NotificationChannelAlertSourceItem notificationChannelAlertSourceItemModel = new NotificationChannelAlertSourceItem.Builder()
    .providerName("testString")
    .findingTypes(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the UpdateNotificationChannelOptions model
    UpdateNotificationChannelOptions updateNotificationChannelOptionsModel = new UpdateNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .name("testString")
    .type("Webhook")
    .endpoint("testString")
    .description("testString")
    .severity(new java.util.ArrayList<String>(java.util.Arrays.asList("low")))
    .enabled(true)
    .alertSource(new java.util.ArrayList<NotificationChannelAlertSourceItem>(java.util.Arrays.asList(notificationChannelAlertSourceItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<UpdateChannelResponse> response = testService.updateNotificationChannel(updateNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    UpdateChannelResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateNotificationChannelPath);
  }

  // Test the updateNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateNotificationChannel(null).execute();
  }

  @Test
  public void testTestNotificationChannelWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"test\": \"test\"}";
    String testNotificationChannelPath = "/v1/testString/notifications/channels/testString/test";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the TestNotificationChannelOptions model
    TestNotificationChannelOptions testNotificationChannelOptionsModel = new TestNotificationChannelOptions.Builder()
    .accountId("testString")
    .channelId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TestChannelResponse> response = testService.testNotificationChannel(testNotificationChannelOptionsModel).execute();
    assertNotNull(response);
    TestChannelResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, testNotificationChannelPath);
  }

  // Test the testNotificationChannel operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTestNotificationChannelNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.testNotificationChannel(null).execute();
  }

  @Test
  public void testGetPublicKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"publicKey\": \"publicKey\"}";
    String getPublicKeyPath = "/v1/testString/notifications/public_key";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPublicKeyOptions model
    GetPublicKeyOptions getPublicKeyOptionsModel = new GetPublicKeyOptions.Builder()
    .accountId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PublicKeyResponse> response = testService.getPublicKey(getPublicKeyOptionsModel).execute();
    assertNotNull(response);
    PublicKeyResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPublicKeyPath);
  }

  // Test the getPublicKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPublicKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getPublicKey(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    testService = null;
  }
}