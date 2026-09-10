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

class CustomObjectRecordsResponseSpec extends Z4jSpec {

    def "should add custom object records item to null list"() {
        given:
        def response = new CustomObjectRecordsResponse()
        def record = new CustomObjectRecord().setName("R1")

        when:
        response.addCustomObjectRecordsItem(record)

        then:
        response.customObjectRecords.size() == 1
        response.customObjectRecords[0] == record
    }

    def "should add custom object records item to existing list"() {
        given:
        def record1 = new CustomObjectRecord().setName("R1")
        def record2 = new CustomObjectRecord().setName("R2")
        def response = new CustomObjectRecordsResponse(customObjectRecords: [record1])

        when:
        response.addCustomObjectRecordsItem(record2)

        then:
        response.customObjectRecords.size() == 2
        response.customObjectRecords.containsAll([record1, record2])
    }
}
