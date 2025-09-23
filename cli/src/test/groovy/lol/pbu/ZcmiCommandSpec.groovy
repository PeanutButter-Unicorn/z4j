package lol.pbu


import lol.pbu.command.ZcmiCommand
import spock.lang.Shared

import java.util.regex.Pattern

class ZcmiCommandSpec extends ZcmiSpec {

    @Shared
    Pattern cliVersion, blankRegex

    def setupSpec() {
        def props = new Properties()
        new File('gradle.properties').withInputStream { stream ->
            props.load(stream)
        }
        cliVersion = Pattern.compile(Pattern.quote(props.getProperty('zencliVersion')))
        blankRegex = Pattern.compile "^\\s*\$"

    }


    void "test zcmi with command line option"() {
        when:
        def (outputStream, errorStream) = executeCommand(ZcmiCommand.class, ctx, args as String[])

        then:
        verifyAll {
            outputStream.matches(cliVersion)
            errorStream.matches(blankRegex)
        }

        where:
        args          | _
        ["-V"]        | _
        ["--version"] | _
    }
}
