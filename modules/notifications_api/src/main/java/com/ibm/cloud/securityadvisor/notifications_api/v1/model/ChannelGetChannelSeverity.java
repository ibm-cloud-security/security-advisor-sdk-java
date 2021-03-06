/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.securityadvisor.notifications_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The severity of the notification.
 */
public class ChannelGetChannelSeverity extends GenericModel {

  protected Boolean critical;
  protected Boolean high;
  protected Boolean medium;
  protected Boolean low;

  /**
   * Gets the critical.
   *
   * Critical severity.
   *
   * @return the critical
   */
  public Boolean isCritical() {
    return critical;
  }

  /**
   * Gets the high.
   *
   * High severity.
   *
   * @return the high
   */
  public Boolean isHigh() {
    return high;
  }

  /**
   * Gets the medium.
   *
   * Medium severity.
   *
   * @return the medium
   */
  public Boolean isMedium() {
    return medium;
  }

  /**
   * Gets the low.
   *
   * Low severity.
   *
   * @return the low
   */
  public Boolean isLow() {
    return low;
  }
}

