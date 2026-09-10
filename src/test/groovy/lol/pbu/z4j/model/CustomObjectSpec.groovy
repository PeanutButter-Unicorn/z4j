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

class CustomObjectSpec extends Z4jSpec {

    def "should instantiate and set properties on CustomObject"() {
        given:
        def obj = new CustomObject("test_key", "Test Title", "Test Plurals")

        when:
        obj.setDescription("A description")
           .setRawTitle("Raw Title")
           .setRawTitlePluralized("Raw Plural")
           .setRawDescription("Raw Desc")
           .setIncludeInListView(true)
           .setAllowsAttachments(true)
           .setAllowsPhotos(false)
           .setCreatedByUserId("123")
           .setUpdatedByUserId("456")
           .setUrl("https://example.zendesk.com/custom_objects/test_key")

        then:
        obj.key == "test_key"
        obj.title == "Test Title"
        obj.titlePluralized == "Test Plurals"
        obj.description == "A description"
        obj.rawTitle == "Raw Title"
        obj.rawTitlePluralized == "Raw Plural"
        obj.rawDescription == "Raw Desc"
        obj.includeInListView
        obj.allowsAttachments
        !obj.allowsPhotos
        obj.createdByUserId == "123"
        obj.updatedByUserId == "456"
        obj.url == "https://example.zendesk.com/custom_objects/test_key"
    }
}
