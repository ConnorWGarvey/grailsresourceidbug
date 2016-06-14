package id.bug

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Integration class ExampleSpec extends Specification {
  void 'the test'() {
    when: def response = new RestBuilder().delete('http://localhost:8080/examples/notavalidid')
    then: response.statusCode == UNPROCESSABLE_ENTITY
  }
}
