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
 * A card element with a time series chart.
 */
public class CardElementsItemTimeSeriesCardElement extends CardElementsItem {

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
    String TIME_SERIES = "TIME_SERIES";
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
    private String defaultInterval;
    private List<Object> valueTypes;

    public Builder(CardElementsItem cardElementsItemTimeSeriesCardElement) {
      this.kind = cardElementsItemTimeSeriesCardElement.kind;
      this.defaultTimeRange = cardElementsItemTimeSeriesCardElement.defaultTimeRange;
      this.text = cardElementsItemTimeSeriesCardElement.text;
      this.defaultInterval = cardElementsItemTimeSeriesCardElement.defaultInterval;
      this.valueTypes = cardElementsItemTimeSeriesCardElement.valueTypes;
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
     * Builds a CardElementsItemTimeSeriesCardElement.
     *
     * @return the cardElementsItemTimeSeriesCardElement
     */
    public CardElementsItemTimeSeriesCardElement build() {
      return new CardElementsItemTimeSeriesCardElement(this);
    }

    /**
     * Adds an valueTypes to valueTypes.
     *
     * @param valueTypes the new valueTypes
     * @return the CardElementsItemTimeSeriesCardElement builder
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
     * @return the CardElementsItemTimeSeriesCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the CardElementsItemTimeSeriesCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CardElementsItemTimeSeriesCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the defaultInterval.
     *
     * @param defaultInterval the defaultInterval
     * @return the CardElementsItemTimeSeriesCardElement builder
     */
    public Builder defaultInterval(String defaultInterval) {
      this.defaultInterval = defaultInterval;
      return this;
    }

    /**
     * Set the valueTypes.
     * Existing valueTypes will be replaced.
     *
     * @param valueTypes the valueTypes
     * @return the CardElementsItemTimeSeriesCardElement builder
     */
    public Builder valueTypes(List<Object> valueTypes) {
      this.valueTypes = valueTypes;
      return this;
    }
  }

  protected CardElementsItemTimeSeriesCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueTypes,
      "valueTypes cannot be null");
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    text = builder.text;
    defaultInterval = builder.defaultInterval;
    valueTypes = builder.valueTypes;
  }

  /**
   * New builder.
   *
   * @return a CardElementsItemTimeSeriesCardElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

