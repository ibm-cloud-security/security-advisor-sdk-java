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
 * FindingCountValueType.
 */
public class FindingCountValueType extends GenericModel {

  /**
   * Kind of element - FINDING_COUNT&#58; Kind of value derived from a count of finding occurrences.
   */
  public interface Kind {
    /** finding_count. */
    String FINDING_COUNT = "FINDING_COUNT";
  }

  protected String kind;
  @SerializedName("finding_note_names")
  protected List<String> findingNoteNames;
  protected String text;

  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private List<String> findingNoteNames;
    private String text;

    private Builder(FindingCountValueType findingCountValueType) {
      this.kind = findingCountValueType.kind;
      this.findingNoteNames = findingCountValueType.findingNoteNames;
      this.text = findingCountValueType.text;
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
     * @param findingNoteNames the findingNoteNames
     * @param text the text
     */
    public Builder(String kind, List<String> findingNoteNames, String text) {
      this.kind = kind;
      this.findingNoteNames = findingNoteNames;
      this.text = text;
    }

    /**
     * Builds a FindingCountValueType.
     *
     * @return the findingCountValueType
     */
    public FindingCountValueType build() {
      return new FindingCountValueType(this);
    }

    /**
     * Adds an findingNoteNames to findingNoteNames.
     *
     * @param findingNoteNames the new findingNoteNames
     * @return the FindingCountValueType builder
     */
    public Builder addFindingNoteNames(String findingNoteNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(findingNoteNames,
        "findingNoteNames cannot be null");
      if (this.findingNoteNames == null) {
        this.findingNoteNames = new ArrayList<String>();
      }
      this.findingNoteNames.add(findingNoteNames);
      return this;
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
     * Set the findingNoteNames.
     * Existing findingNoteNames will be replaced.
     *
     * @param findingNoteNames the findingNoteNames
     * @return the FindingCountValueType builder
     */
    public Builder findingNoteNames(List<String> findingNoteNames) {
      this.findingNoteNames = findingNoteNames;
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

  protected FindingCountValueType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.findingNoteNames,
      "findingNoteNames cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    kind = builder.kind;
    findingNoteNames = builder.findingNoteNames;
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
   * Gets the findingNoteNames.
   *
   * the names of the finding note associated that act as filters for counting the occurrences.
   *
   * @return the findingNoteNames
   */
  public List<String> findingNoteNames() {
    return findingNoteNames;
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

