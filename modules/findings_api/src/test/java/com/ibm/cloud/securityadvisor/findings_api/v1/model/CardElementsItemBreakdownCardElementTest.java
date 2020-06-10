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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.securityadvisor.findings_api.v1.utils.TestUtilities;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the BreakdownCardElement model.
 */
public class CardElementsItemBreakdownCardElementTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testBreakdownCardElement() throws Throwable {
    KpiValueType kpiTypeModel = new KpiValueType.Builder()
      .kind("KPI")
      .kpiNoteName("string")
      .text("testString")
      .build();

    CardElementsItemBreakdownCardElement breakdownCardElementModel = new CardElementsItemBreakdownCardElement.Builder()
      .kind("BreakdownCardElement")
      .defaultTimeRange("1d")
      .text("testString")
      .valueTypes(new java.util.ArrayList<Object>(java.util.Arrays.asList(kpiTypeModel)))
      .build();
    assertEquals(breakdownCardElementModel.kind(), "BreakdownCardElement");
    assertEquals(breakdownCardElementModel.defaultTimeRange(), "1d");
    assertEquals(breakdownCardElementModel.text(), "testString");
    assertEquals(breakdownCardElementModel.valueTypes(), new java.util.ArrayList<Object>(java.util.Arrays.asList(kpiTypeModel)));

    String json = TestUtilities.serialize(breakdownCardElementModel);

    CardElementsItemBreakdownCardElement breakdownCardElementModelNew = TestUtilities.deserialize(json, CardElementsItemBreakdownCardElement.class);
    assertTrue(breakdownCardElementModelNew instanceof CardElementsItemBreakdownCardElement);
    assertEquals(breakdownCardElementModelNew.kind(), "BreakdownCardElement");
    assertEquals(breakdownCardElementModelNew.defaultTimeRange(), "1d");
    assertEquals(breakdownCardElementModelNew.text(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testBreakdownCardElementError() throws Throwable {
    new CardElementsItemBreakdownCardElement.Builder().build();
  }

}