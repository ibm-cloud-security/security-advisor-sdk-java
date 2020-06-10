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

/**
 * A card element with a breakdown of values.
 */
public class CardElementsItemBreakdownCardElement extends CardElementsItem {

  /**
   * Kind of element
   * - NUMERIC&#58; Single numeric value
   * - BREAKDOWN&#58; Breakdown of numeric values
   * - TIME_SERIES&#58; Time-series of numeric values.
   */
  public interface Kind {
    /** numeric. */
    String NUMERIC = "NUMERIC";
    /** breakdown. */
    String BREAKDOWN = "BREAKDOWN";
    /** time_series. */
    String TIME_SERIES = "TIMESERIES";
  }

  /**
   * The default time range of this card element.
   */
  public interface DefaultTimeRange {
    /** one_day. */
    String ONE_DAY = "1d";
    /** two_day. */
    String TWO_DAY = "2d";
    /** three_day. */
    String THREE_DAY = "3d";
    /** four_day. */
    String FOUR_DAY = "4d";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String defaultTimeRange;
    private String text;
    private List<Object> valueTypes;

    public Builder(CardElementsItem cardElementsItemBreakdownCardElement) {
      this.kind = cardElementsItemBreakdownCardElement.kind;
      this.defaultTimeRange = cardElementsItemBreakdownCardElement.defaultTimeRange;
      this.text = cardElementsItemBreakdownCardElement.text;
      this.valueTypes = cardElementsItemBreakdownCardElement.valueTypes;
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
     * @param text the text
     * @param valueTypes the valueTypes
     */
    public Builder(String kind, String text, List<Object> valueTypes) {
      this.kind = kind;
      this.text = text;
      this.valueTypes = valueTypes;
    }

    /**
     * Builds a CardElementsItemBreakdownCardElement.
     *
     * @return the cardElementsItemBreakdownCardElement
     */
    public CardElementsItemBreakdownCardElement build() {
      return new CardElementsItemBreakdownCardElement(this);
    }

    /**
     * Adds an valueTypes to valueTypes.
     *
     * @param valueTypes the new valueTypes
     * @return the CardElementsItemBreakdownCardElement builder
     */
    public Builder addValueTypes(Object valueTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(valueTypes,
        "valueTypes cannot be null");
      if (this.valueTypes == null) {
        this.valueTypes = new ArrayList<Object>();
      }
      this.valueTypes.add(valueTypes);
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CardElementsItemBreakdownCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the CardElementsItemBreakdownCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CardElementsItemBreakdownCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the valueTypes.
     * Existing valueTypes will be replaced.
     *
     * @param arrayList the valueTypes
     * @return the CardElementsItemBreakdownCardElement builder
     */
    public Builder valueTypes(ArrayList<Object> arrayList) {
      this.valueTypes = arrayList;
      return this;
    }
  }

  protected CardElementsItemBreakdownCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueTypes,
      "valueTypes cannot be null");
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    text = builder.text;
    valueTypes = builder.valueTypes;
  }

  /**
   * New builder.
   *
   * @return a CardElementsItemBreakdownCardElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

