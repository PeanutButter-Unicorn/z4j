package lol.pbu.z4j.client

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import lol.pbu.z4j.model.CreateUserSegmentRequest
import lol.pbu.z4j.model.UserSegment
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

    def "can create user segment with '#userSegment' user type"() {
        when:
        def response = userSegmentsClient.createUserSegment(new CreateUserSegmentRequest(
                new UserSegment(userSegment, userSegment)))

        then: "received expected 201 response"
        response.status() == HttpStatus.CREATED

        where:
        userSegment       | _
        "signed_in_users" | _
        "staff"           | _
    }
}