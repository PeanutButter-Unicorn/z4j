/*
 * Copyright 2026 Peanut Butter Unicorn, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lol.pbu.z4j.model

import lol.pbu.z4j.Z4jSpec

class CustomObjectRecordSpec extends Z4jSpec {

    def "should instantiate and set properties on CustomObjectRecord"() {
        given:
        def record = new CustomObjectRecord()

        when:
        record.setId("rec_123")
              .setName("Record One")
              .setCustomObjectKey("my_obj")
              .setExternalId("ext_456")
              .setCreatedByUserId("789")
              .setUpdatedByUserId("101")
              .setUrl("https://example.zendesk.com/records/rec_123")
              .putCustomObjectFieldsItem("field1", "value1")

        then:
        record.id == "rec_123"
        record.name == "Record One"
        record.customObjectKey == "my_obj"
        record.externalId == "ext_456"
        record.createdByUserId == "789"
        record.updatedByUserId == "101"
        record.url == "https://example.zendesk.com/records/rec_123"
        record.customObjectFields["field1"] == "value1"
    }
}
