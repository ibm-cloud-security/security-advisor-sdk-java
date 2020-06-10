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
package com.ibm.cloud.securityadvisor.findings_api.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.securityadvisor.common.SdkCommon;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListNotesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiNote;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListNotesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.ListProvidersOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.PostGraphOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.UpdateNoteOptions;
import com.ibm.cloud.securityadvisor.findings_api.v1.model.UpdateOccurrenceOptions;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Findings API
 * .
 *
 * @version v1
 */
public class FindingsApi extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "findings_api";

  public static final String DEFAULT_SERVICE_URL = "https://findings-api.cloud.ibm.com/findings";

 /**
   * Class method which constructs an instance of the `FindingsApi` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `FindingsApi` client using external configuration
   */
  public static FindingsApi newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `FindingsApi` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `FindingsApi` client using external configuration
   */
  public static FindingsApi newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    FindingsApi service = new FindingsApi(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `FindingsApi` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public FindingsApi(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * query findings.
   *
   * query findings.
   *
   * @param postGraphOptions the {@link PostGraphOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> postGraph(PostGraphOptions postGraphOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(postGraphOptions,
      "postGraphOptions cannot be null");
    String[] pathSegments = { "v1", "graph" };
    String[] pathParameters = { postGraphOptions.accountId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "postGraph");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (postGraphOptions.contentType() != null) {
      builder.header("Content-Type", postGraphOptions.contentType());
    }
    builder.bodyContent(postGraphOptions.contentType(), postGraphOptions.body(),
      null, postGraphOptions.body());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Creates a new `Note`.
   *
   * @param createNoteOptions the {@link CreateNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> createNote(CreateNoteOptions createNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createNoteOptions,
      "createNoteOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes" };
    String[] pathParameters = { createNoteOptions.accountId(), createNoteOptions.providerId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "createNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("short_description", createNoteOptions.shortDescription());
    contentJson.addProperty("long_description", createNoteOptions.longDescription());
    contentJson.addProperty("kind", createNoteOptions.kind());
    contentJson.addProperty("id", createNoteOptions.id());
    contentJson.add("reported_by", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.reportedBy()));
    if (createNoteOptions.relatedUrl() != null) {
      contentJson.add("related_url", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.relatedUrl()));
    }
    if (createNoteOptions.expirationTime() != null) {
      contentJson.add("expiration_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.expirationTime()));
    }
    if (createNoteOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.createTime()));
    }
    if (createNoteOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.updateTime()));
    }
    if (createNoteOptions.shared() != null) {
      contentJson.addProperty("shared", createNoteOptions.shared());
    }
    if (createNoteOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.finding()));
    }
    if (createNoteOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.kpi()));
    }
    if (createNoteOptions.card() != null) {
      contentJson.add("card", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.card()));
    }
    if (createNoteOptions.section() != null) {
      contentJson.add("section", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createNoteOptions.section()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lists all `Notes` for a given provider.
   *
   * @param listNotesOptions the {@link ListNotesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListNotesResponse}
   */
  public ServiceCall<ApiListNotesResponse> listNotes(ListNotesOptions listNotesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listNotesOptions,
      "listNotesOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes" };
    String[] pathParameters = { listNotesOptions.accountId(), listNotesOptions.providerId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "listNotes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listNotesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listNotesOptions.pageSize()));
    }
    if (listNotesOptions.pageToken() != null) {
      builder.query("page_token", listNotesOptions.pageToken());
    }
    ResponseConverter<ApiListNotesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListNotesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns the requested `Note`.
   *
   * @param getNoteOptions the {@link GetNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> getNote(GetNoteOptions getNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getNoteOptions,
      "getNoteOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes" };
    String[] pathParameters = { getNoteOptions.accountId(), getNoteOptions.providerId(), getNoteOptions.noteId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "getNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Updates an existing `Note`.
   *
   * @param updateNoteOptions the {@link UpdateNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> updateNote(UpdateNoteOptions updateNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateNoteOptions,
      "updateNoteOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes" };
    String[] pathParameters = { updateNoteOptions.accountId(), updateNoteOptions.providerId(), updateNoteOptions.noteId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "updateNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("short_description", updateNoteOptions.shortDescription());
    contentJson.addProperty("long_description", updateNoteOptions.longDescription());
    contentJson.addProperty("kind", updateNoteOptions.kind());
    contentJson.addProperty("id", updateNoteOptions.id());
    contentJson.add("reported_by", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.reportedBy()));
    if (updateNoteOptions.relatedUrl() != null) {
      contentJson.add("related_url", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.relatedUrl()));
    }
    if (updateNoteOptions.expirationTime() != null) {
      contentJson.add("expiration_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.expirationTime()));
    }
    if (updateNoteOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.createTime()));
    }
    if (updateNoteOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.updateTime()));
    }
    if (updateNoteOptions.shared() != null) {
      contentJson.addProperty("shared", updateNoteOptions.shared());
    }
    if (updateNoteOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.finding()));
    }
    if (updateNoteOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.kpi()));
    }
    if (updateNoteOptions.card() != null) {
      contentJson.add("card", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.card()));
    }
    if (updateNoteOptions.section() != null) {
      contentJson.add("section", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateNoteOptions.section()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deletes the given `Note` from the system.
   *
   * @param deleteNoteOptions the {@link DeleteNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteNote(DeleteNoteOptions deleteNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNoteOptions,
      "deleteNoteOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes" };
    String[] pathParameters = { deleteNoteOptions.accountId(), deleteNoteOptions.providerId(), deleteNoteOptions.noteId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "deleteNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Gets the `Note` attached to the given `Occurrence`.
   *
   * @param getOccurrenceNoteOptions the {@link GetOccurrenceNoteOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiNote}
   */
  public ServiceCall<ApiNote> getOccurrenceNote(GetOccurrenceNoteOptions getOccurrenceNoteOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOccurrenceNoteOptions,
      "getOccurrenceNoteOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences", "note" };
    String[] pathParameters = { getOccurrenceNoteOptions.accountId(), getOccurrenceNoteOptions.providerId(), getOccurrenceNoteOptions.occurrenceId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "getOccurrenceNote");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ApiNote> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiNote>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Creates a new `Occurrence`. Use this method to create `Occurrences` for a resource.
   *
   * @param createOccurrenceOptions the {@link CreateOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiOccurrence}
   */
  public ServiceCall<ApiOccurrence> createOccurrence(CreateOccurrenceOptions createOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createOccurrenceOptions,
      "createOccurrenceOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences" };
    String[] pathParameters = { createOccurrenceOptions.accountId(), createOccurrenceOptions.providerId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "createOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createOccurrenceOptions.replaceIfExists() != null) {
      builder.header("Replace-If-Exists", createOccurrenceOptions.replaceIfExists());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("note_name", createOccurrenceOptions.noteName());
    contentJson.addProperty("kind", createOccurrenceOptions.kind());
    contentJson.addProperty("id", createOccurrenceOptions.id());
    if (createOccurrenceOptions.resourceUrl() != null) {
      contentJson.addProperty("resource_url", createOccurrenceOptions.resourceUrl());
    }
    if (createOccurrenceOptions.remediation() != null) {
      contentJson.addProperty("remediation", createOccurrenceOptions.remediation());
    }
    if (createOccurrenceOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.createTime()));
    }
    if (createOccurrenceOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.updateTime()));
    }
    if (createOccurrenceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.context()));
    }
    if (createOccurrenceOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.finding()));
    }
    if (createOccurrenceOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createOccurrenceOptions.kpi()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiOccurrence> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiOccurrence>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lists active `Occurrences` for a given provider matching the filters.
   *
   * @param listOccurrencesOptions the {@link ListOccurrencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListOccurrencesResponse}
   */
  public ServiceCall<ApiListOccurrencesResponse> listOccurrences(ListOccurrencesOptions listOccurrencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listOccurrencesOptions,
      "listOccurrencesOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences" };
    String[] pathParameters = { listOccurrencesOptions.accountId(), listOccurrencesOptions.providerId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "listOccurrences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listOccurrencesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listOccurrencesOptions.pageSize()));
    }
    if (listOccurrencesOptions.pageToken() != null) {
      builder.query("page_token", listOccurrencesOptions.pageToken());
    }
    ResponseConverter<ApiListOccurrencesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListOccurrencesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lists `Occurrences` referencing the specified `Note`. Use this method to get all occurrences referencing your `Note` across all your customer providers.
   *
   * @param listNoteOccurrencesOptions the {@link ListNoteOccurrencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListNoteOccurrencesResponse}
   */
  public ServiceCall<ApiListNoteOccurrencesResponse> listNoteOccurrences(ListNoteOccurrencesOptions listNoteOccurrencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listNoteOccurrencesOptions,
      "listNoteOccurrencesOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "notes", "occurrences" };
    String[] pathParameters = { listNoteOccurrencesOptions.accountId(), listNoteOccurrencesOptions.providerId(), listNoteOccurrencesOptions.noteId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "listNoteOccurrences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listNoteOccurrencesOptions.pageSize() != null) {
      builder.query("page_size", String.valueOf(listNoteOccurrencesOptions.pageSize()));
    }
    if (listNoteOccurrencesOptions.pageToken() != null) {
      builder.query("page_token", listNoteOccurrencesOptions.pageToken());
    }
    ResponseConverter<ApiListNoteOccurrencesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListNoteOccurrencesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Returns the requested `Occurrence`.
   *
   * @param getOccurrenceOptions the {@link GetOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListOccurrencesResponse}
   */
  public ServiceCall<ApiListOccurrencesResponse> getOccurrence(GetOccurrenceOptions getOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getOccurrenceOptions,
      "getOccurrenceOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences" };
    String[] pathParameters = { getOccurrenceOptions.accountId(), getOccurrenceOptions.providerId(), getOccurrenceOptions.occurrenceId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "getOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ApiListOccurrencesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListOccurrencesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Updates an existing `Occurrence`.
   *
   * @param updateOccurrenceOptions the {@link UpdateOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiOccurrence}
   */
  public ServiceCall<ApiOccurrence> updateOccurrence(UpdateOccurrenceOptions updateOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateOccurrenceOptions,
      "updateOccurrenceOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences" };
    String[] pathParameters = { updateOccurrenceOptions.accountId(), updateOccurrenceOptions.providerId(), updateOccurrenceOptions.occurrenceId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "updateOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("note_name", updateOccurrenceOptions.noteName());
    contentJson.addProperty("kind", updateOccurrenceOptions.kind());
    contentJson.addProperty("id", updateOccurrenceOptions.id());
    if (updateOccurrenceOptions.resourceUrl() != null) {
      contentJson.addProperty("resource_url", updateOccurrenceOptions.resourceUrl());
    }
    if (updateOccurrenceOptions.remediation() != null) {
      contentJson.addProperty("remediation", updateOccurrenceOptions.remediation());
    }
    if (updateOccurrenceOptions.createTime() != null) {
      contentJson.add("create_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.createTime()));
    }
    if (updateOccurrenceOptions.updateTime() != null) {
      contentJson.add("update_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.updateTime()));
    }
    if (updateOccurrenceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.context()));
    }
    if (updateOccurrenceOptions.finding() != null) {
      contentJson.add("finding", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.finding()));
    }
    if (updateOccurrenceOptions.kpi() != null) {
      contentJson.add("kpi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateOccurrenceOptions.kpi()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ApiOccurrence> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiOccurrence>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Deletes the given `Occurrence` from the system.
   *
   * @param deleteOccurrenceOptions the {@link DeleteOccurrenceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteOccurrence(DeleteOccurrenceOptions deleteOccurrenceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteOccurrenceOptions,
      "deleteOccurrenceOptions cannot be null");
    String[] pathSegments = { "v1", "providers", "occurrences" };
    String[] pathParameters = { deleteOccurrenceOptions.accountId(), deleteOccurrenceOptions.providerId(), deleteOccurrenceOptions.occurrenceId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "deleteOccurrence");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lists all `Providers` for a given account id.
   *
   * @param listProvidersOptions the {@link ListProvidersOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ApiListProvidersResponse}
   */
  public ServiceCall<ApiListProvidersResponse> listProviders(ListProvidersOptions listProvidersOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProvidersOptions,
      "listProvidersOptions cannot be null");
    String[] pathSegments = { "v1", "providers" };
    String[] pathParameters = { listProvidersOptions.accountId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("findings_api", "v1", "listProviders");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listProvidersOptions.limit() != null) {
      builder.query("limit", String.valueOf(listProvidersOptions.limit()));
    }
    if (listProvidersOptions.skip() != null) {
      builder.query("skip", String.valueOf(listProvidersOptions.skip()));
    }
    if (listProvidersOptions.startProviderId() != null) {
      builder.query("start_provider_id", listProvidersOptions.startProviderId());
    }
    if (listProvidersOptions.endProviderId() != null) {
      builder.query("end_provider_id", listProvidersOptions.endProviderId());
    }
    ResponseConverter<ApiListProvidersResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ApiListProvidersResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
