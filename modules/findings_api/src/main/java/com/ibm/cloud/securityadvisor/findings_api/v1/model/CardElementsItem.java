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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CardElementsItem.
 *
 * Classes which extend this class:
 * - CardElementsItemNumericCardElement
 * - CardElementsItemBreakdownCardElement
 * - CardElementsItemTimeSeriesCardElement
 */
public class CardElementsItem extends GenericModel {

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

  protected String kind;
  @SerializedName("default_time_range")
  protected String defaultTimeRange;
  protected String text;
  @SerializedName("value_type")
  protected Object valueType;
  @SerializedName("value_types")
  protected List<Object> valueTypes;
  @SerializedName("default_interval")
  protected String defaultInterval;

  protected CardElementsItem() {
  }

  /**
   * Gets the kind.
   *
   * Kind of element
   * - NUMERIC&#58; Single numeric value
   * - BREAKDOWN&#58; Breakdown of numeric values
   * - TIME_SERIES&#58; Time-series of numeric values.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the defaultTimeRange.
   *
   * The default time range of this card element.
   *
   * @return the defaultTimeRange
   */
  public String defaultTimeRange() {
    return defaultTimeRange;
  }

  /**
   * Gets the text.
   *
   * The text of this card element.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the valueType.
   *
   * @return the valueType
   */
  public Object valueType() {
    return valueType;
  }

  /**
   * Gets the valueTypes.
   *
   * the value types associated to this card element.
   *
   * @return the valueTypes
   */
  public List<Object> valueTypes() {
    return valueTypes;
  }

  /**
   * Gets the defaultInterval.
   *
   * The default interval of the time series.
   *
   * @return the defaultInterval
   */
  public String defaultInterval() {
    return defaultInterval;
  }
}

