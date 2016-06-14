package id.bug

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Integration @Unroll class ExampleSpec extends Specification {
  def 'invalid ID for #method'() {
    when: def response = new RestBuilder()."$method"('http://localhost:8080/examples/notavalidid')
    then: response.statusCode == UNPROCESSABLE_ENTITY
    where: method << ['delete', 'get']
  }
}
