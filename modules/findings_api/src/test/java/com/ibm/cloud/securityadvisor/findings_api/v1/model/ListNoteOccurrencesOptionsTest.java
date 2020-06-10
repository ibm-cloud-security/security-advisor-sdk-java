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
 * Unit test class for the ListNoteOccurrencesOptions model.
 */
public class ListNoteOccurrencesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListNoteOccurrencesOptions() throws Throwable {
    ListNoteOccurrencesOptions listNoteOccurrencesOptionsModel = new ListNoteOccurrencesOptions.Builder()
      .accountId("testString")
      .providerId("testString")
      .noteId("testString")
      .pageSize(Long.valueOf("26"))
      .pageToken("testString")
      .build();
    assertEquals(listNoteOccurrencesOptionsModel.accountId(), "testString");
    assertEquals(listNoteOccurrencesOptionsModel.providerId(), "testString");
    assertEquals(listNoteOccurrencesOptionsModel.noteId(), "testString");
    assertEquals(listNoteOccurrencesOptionsModel.pageSize(), Long.valueOf("26"));
    assertEquals(listNoteOccurrencesOptionsModel.pageToken(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListNoteOccurrencesOptionsError() throws Throwable {
    new ListNoteOccurrencesOptions.Builder().build();
  }

}