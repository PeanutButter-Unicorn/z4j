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

class TicketFormSpec extends Z4jSpec {

    def "should instantiate and set properties on TicketForm"() {
        given:
        def form = new TicketForm("Test Form")

        when:
        form.setId(123L)
            .setDisplayName("Display Name")
            .setRawName("Raw Name")
            .setRawDisplayName("Raw Display")
            .setPosition(1L)
            .setActive(true)
            .setDefaultForm(true)
            .setEndUserVisible(true)
            .setInAllBrands(true)
            .setRestrictedBrandIds([1L, 2L])
            .setUrl("https://example.zendesk.com")
            .addTicketFieldIdsItem(456L)

        then:
        form.id == 123L
        form.name == "Test Form"
        form.displayName == "Display Name"
        form.rawName == "Raw Name"
        form.rawDisplayName == "Raw Display"
        form.position == 1L
        form.active
        form.defaultForm
        form.endUserVisible
        form.inAllBrands
        form.restrictedBrandIds == [1L, 2L]
        form.ticketFieldIds == [456L]
        form.url == "https://example.zendesk.com"
    }

    def "should add ticket field IDs when list already exists"() {
        given:
        def form = new TicketForm("Test Form")
        form.ticketFieldIds = [100L]

        when:
        form.addTicketFieldIdsItem(200L)

        then:
        form.ticketFieldIds == [100L, 200L]
    }
}
