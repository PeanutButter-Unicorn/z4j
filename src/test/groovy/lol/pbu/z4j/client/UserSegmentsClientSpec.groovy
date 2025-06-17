package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class UserSegmentsClientSpec extends Specification {

    @Inject
    @Shared
    UserSegmentsClient userSegmentsClient


    def "can list user segments"() {
        when: "list user segments with query value '#segmentQuery'"
        def response = userSegmentsClient.listUserSegments(segmentQuery)

        then: "received expected 200 response"
        response.status() == HttpStatus.OK

        where:
        segmentQuery | _
        null         | _
        true         | _
        false        | _
    }
}