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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * KpiValueType.
 */
public class KpiValueType extends GenericModel {

  /**
   * Kind of element - KPI&#58; Kind of value derived from a KPI occurrence.
   */
  public interface Kind {
    /** kpi. */
    String KPI = "KPI";
  }

  protected String kind;
  @SerializedName("kpi_note_name")
  protected String kpiNoteName;
  protected String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String kpiNoteName;
    private String text;

    private Builder(KpiValueType kpiValueType) {
      this.kind = kpiValueType.kind;
      this.kpiNoteName = kpiValueType.kpiNoteName;
      this.text = kpiValueType.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param kind the kind
     * @param kpiNoteName the kpiNoteName
     * @param text the text
     */
    public Builder(String kind, String kpiNoteName, String text) {
      this.kind = kind;
      this.kpiNoteName = kpiNoteName;
      this.text = text;
    }

    /**
     * Builds a kpiValueType.
     *
     * @return the kpiValueType
     */
    public KpiValueType build() {
      return new KpiValueType(this);
    }


    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the FindingCountValueType builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the kpiNoteName.
     * Existing kpiNoteName will be replaced.
     *
     * @param kpiNoteName the kpiNoteName
     * @return the KpiValueType builder
     */
    public Builder kpiNoteName(String kpiNoteName) {
      this.kpiNoteName = kpiNoteName;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the FindingCountValueType builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected KpiValueType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kpiNoteName,
      "kpiNoteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    kind = builder.kind;
    kpiNoteName = builder.kpiNoteName;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a FindingCountValueType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the kind.
   *
   * Kind of element - FINDING_COUNT&#58; Kind of value derived from a count of finding occurrences.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the kpiNoteName.
   *
   * The name of the kpi note associated to the occurrence with the value for this card element value type
   *
   * @return the kpiNoteName
   */
  public String kpiNoteName() {
    return kpiNoteName;
  }

  /**
   * Gets the text.
   *
   * The text of this element type.
   *
   * @return the text
   */
  public String text() {
    return text;
  }
}

