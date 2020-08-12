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
package com.ibm.cloud.securityadvisor.findings_api.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Finding provides details about a finding occurrence.
 */
public class Finding extends GenericModel {

  /**
   * The common severity of this `Occurrence`.
   */
  public interface Severity {
    /** LOW. */
    String LOW = "LOW";
    /** MEDIUM. */
    String MEDIUM = "MEDIUM";
    /** HIGH. */
    String HIGH = "HIGH";
    /** CRITICAL. */
    String CRITICAL = "CRITICAL";
  }

  /**
   * The confidence level on this `Occurrence`.
   */
  public interface Certainty {
    /** LOW. */
    String LOW = "LOW";
    /** MEDIUM. */
    String MEDIUM = "MEDIUM";
    /** HIGH. */
    String HIGH = "HIGH";
  }

  protected String severity;
  protected String certainty;
  @SerializedName("next_steps")
  protected List<RemediationStep> nextSteps;
  @SerializedName("network_connection")
  protected NetworkConnection networkConnection;
  @SerializedName("data_transferred")
  protected DataTransferred dataTransferred;

  /**
   * Builder.
   */
  public static class Builder {
    private String severity;
    private String certainty;
    private List<RemediationStep> nextSteps;
    private NetworkConnection networkConnection;
    private DataTransferred dataTransferred;

    private Builder(Finding finding) {
      this.severity = finding.severity;
      this.certainty = finding.certainty;
      this.nextSteps = finding.nextSteps;
      this.networkConnection = finding.networkConnection;
      this.dataTransferred = finding.dataTransferred;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Finding.
     *
     * @return the new Finding instance
     */
    public Finding build() {
      return new Finding(this);
    }

    /**
     * Adds an nextSteps to nextSteps.
     *
     * @param nextSteps the new nextSteps
     * @return the Finding builder
     */
    public Builder addNextSteps(RemediationStep nextSteps) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(nextSteps,
        "nextSteps cannot be null");
      if (this.nextSteps == null) {
        this.nextSteps = new ArrayList<RemediationStep>();
      }
      this.nextSteps.add(nextSteps);
      return this;
    }

    /**
     * Set the severity.
     *
     * @param severity the severity
     * @return the Finding builder
     */
    public Builder severity(String severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Set the certainty.
     *
     * @param certainty the certainty
     * @return the Finding builder
     */
    public Builder certainty(String certainty) {
      this.certainty = certainty;
      return this;
    }

    /**
     * Set the nextSteps.
     * Existing nextSteps will be replaced.
     *
     * @param nextSteps the nextSteps
     * @return the Finding builder
     */
    public Builder nextSteps(List<RemediationStep> nextSteps) {
      this.nextSteps = nextSteps;
      return this;
    }

    /**
     * Set the networkConnection.
     *
     * @param networkConnection the networkConnection
     * @return the Finding builder
     */
    public Builder networkConnection(NetworkConnection networkConnection) {
      this.networkConnection = networkConnection;
      return this;
    }

    /**
     * Set the dataTransferred.
     *
     * @param dataTransferred the dataTransferred
     * @return the Finding builder
     */
    public Builder dataTransferred(DataTransferred dataTransferred) {
      this.dataTransferred = dataTransferred;
      return this;
    }
  }

  protected Finding(Builder builder) {
    severity = builder.severity;
    certainty = builder.certainty;
    nextSteps = builder.nextSteps;
    networkConnection = builder.networkConnection;
    dataTransferred = builder.dataTransferred;
  }

  /**
   * New builder.
   *
   * @return a Finding builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the severity.
   *
   * The common severity of this `Occurrence`.
   *
   * @return the severity
   */
  public String severity() {
    return severity;
  }

  /**
   * Gets the certainty.
   *
   * The confidence level on this `Occurrence`.
   *
   * @return the certainty
   */
  public String certainty() {
    return certainty;
  }

  /**
   * Gets the nextSteps.
   *
   * Remediation steps for the issues reported in this finding. They override the note's next steps.
   *
   * @return the nextSteps
   */
  public List<RemediationStep> nextSteps() {
    return nextSteps;
  }

  /**
   * Gets the networkConnection.
   *
   * Network connection details of this finding.
   *
   * @return the networkConnection
   */
  public NetworkConnection networkConnection() {
    return networkConnection;
  }

  /**
   * Gets the dataTransferred.
   *
   * Data transferred details of this finding.
   *
   * @return the dataTransferred
   */
  public DataTransferred dataTransferred() {
    return dataTransferred;
  }
}

