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

class CustomObjectsResponseSpec extends Z4jSpec {

    def "should add custom objects item to null list"() {
        given:
        def response = new CustomObjectsResponse()
        def obj = new CustomObject("k1", "T1", "P1")

        when:
        response.addCustomObjectsItem(obj)

        then:
        response.customObjects.size() == 1
        response.customObjects[0] == obj
    }

    def "should add custom objects item to existing list"() {
        given:
        def obj1 = new CustomObject("k1", "T1", "P1")
        def obj2 = new CustomObject("k2", "T2", "P2")
        def response = new CustomObjectsResponse(customObjects: [obj1])

        when:
        response.addCustomObjectsItem(obj2)

        then:
        response.customObjects.size() == 2
        response.customObjects.containsAll([obj1, obj2])
    }
}
