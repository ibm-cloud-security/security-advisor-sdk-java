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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * the value type of a card element.
 */
public class ValueType extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "kind";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
  }

  /**
   * Kind of element - KPI&amp;#58; Kind of value derived from a KPI occurrence - FINDING_COUNT&amp;#58; Kind of value
   * derived from a count of finding occurrences.
   */
  public interface Kind {
    /** KPI. */
    String KPI = "KPI";
    /** FINDING_COUNT. */
    String FINDING_COUNT = "FINDING_COUNT";
  }

  protected String kind;
  protected String text;

  /**
   * Gets the kind.
   *
   * Kind of element - KPI&amp;#58; Kind of value derived from a KPI occurrence - FINDING_COUNT&amp;#58; Kind of value
   * derived from a count of finding occurrences.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
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

  /**
   * Sets the kind.
   *
   * Kind of element - KPI&amp;#58; Kind of value derived from a KPI occurrence - FINDING_COUNT&amp;#58; Kind of value
   * derived from a count of finding occurrences.
   *
   */
  public void setKind(String kind) {
    this.kind = kind;
  }

  /**
   * Sets the text.
   *
   * The text of this element type.
   *
   */
  public void setText(String text) {
    this.text = text;
  }
}

