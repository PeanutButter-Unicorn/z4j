package lol.pbu

import lol.pbu.command.LocaleCommand

class LocaleCommandSpec extends ZcmiSpec {

    def "test list locales"() {
        when:
        def (outputStream, errorStream) = executeCommand(LocaleCommand.class, ctx, args as String[])

        then:
        verifyAll {
            outputStream.matches(blankRegex)
            errorStream.matches(blankRegex)
        }

        where:
        args     | _
        ["list"] | _
        ["ls"]   | _

    }

}
