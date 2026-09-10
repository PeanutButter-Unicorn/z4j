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

class TicketFormsResponseSpec extends Z4jSpec {

    def "should add ticket forms item to null list"() {
        given:
        def response = new TicketFormsResponse()
        def form = new TicketForm("Form 1")

        when:
        response.addTicketFormsItem(form)

        then:
        response.ticketForms.size() == 1
        response.ticketForms[0] == form
    }

    def "should add ticket forms item to existing list"() {
        given:
        def form1 = new TicketForm("Form 1")
        def form2 = new TicketForm("Form 2")
        def response = new TicketFormsResponse(ticketForms: [form1])

        when:
        response.addTicketFormsItem(form2)

        then:
        response.ticketForms.size() == 2
        response.ticketForms.containsAll([form1, form2])
    }
}
