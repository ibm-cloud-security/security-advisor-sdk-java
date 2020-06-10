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
 * Unit test class for the Card model.
 */
public class CardTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCard() throws Throwable {
    FindingCountValueType findingCountValueTypeModel = new FindingCountValueType.Builder()
      .kind("FINDING_COUNT")
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .text("testString")
      .build();
    assertEquals(findingCountValueTypeModel.kind(), "FINDING_COUNT");
    assertEquals(findingCountValueTypeModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(findingCountValueTypeModel.text(), "testString");

    CardElementsItemTimeSeriesCardElement cardElementModel = new CardElementsItemTimeSeriesCardElement.Builder()
      .kind("TimeSeriesCardElement")
      .defaultTimeRange("1d")
      .text("testString")
      .defaultInterval("testString")
      .valueTypes(new java.util.ArrayList<Object>(java.util.Arrays.asList(findingCountValueTypeModel)))
      .build();
    assertEquals(cardElementModel.kind(), "TimeSeriesCardElement");
    assertEquals(cardElementModel.defaultTimeRange(), "1d");
    assertEquals(cardElementModel.text(), "testString");
    assertEquals(cardElementModel.defaultInterval(), "testString");
    assertEquals(cardElementModel.valueTypes(), new java.util.ArrayList<Object>(java.util.Arrays.asList(findingCountValueTypeModel)));

    Card cardModel = new Card.Builder()
      .section("testString")
      .title("testString")
      .subtitle("testString")
      .order(Long.valueOf("1"))
      .findingNoteNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .requiresConfiguration(true)
      .badgeText("testString")
      .badgeImage("testString")
      .elements(new java.util.ArrayList<>(java.util.Arrays.asList(cardElementModel)))
      .build();
    assertEquals(cardModel.section(), "testString");
    assertEquals(cardModel.title(), "testString");
    assertEquals(cardModel.subtitle(), "testString");
    assertEquals(cardModel.order(), Long.valueOf("1"));
    assertEquals(cardModel.findingNoteNames(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(cardModel.requiresConfiguration(), Boolean.valueOf(true));
    assertEquals(cardModel.badgeText(), "testString");
    assertEquals(cardModel.badgeImage(), "testString");
    assertEquals(cardModel.elements(), new java.util.ArrayList<>(java.util.Arrays.asList(cardElementModel)));

    String json = TestUtilities.serialize(cardModel);

    Card cardModelNew = TestUtilities.deserialize(json, Card.class);
    assertTrue(cardModelNew instanceof Card);
    assertEquals(cardModelNew.section(), "testString");
    assertEquals(cardModelNew.title(), "testString");
    assertEquals(cardModelNew.subtitle(), "testString");
    assertEquals(cardModelNew.order(), Long.valueOf("1"));
    assertEquals(cardModelNew.requiresConfiguration(), Boolean.valueOf(true));
    assertEquals(cardModelNew.badgeText(), "testString");
    assertEquals(cardModelNew.badgeImage(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCardError() throws Throwable {
    new Card.Builder().build();
  }

}