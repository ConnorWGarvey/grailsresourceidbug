package id.bug

import static org.springframework.http.HttpStatus.NOT_FOUND
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
    then: response.statusCode == NOT_FOUND
    where: method << ['delete', 'get']
  }

  def 'invalid ID for update using #method'() {
    when: def response = new RestBuilder()."$method"('http://localhost:8080/examples/notavalidid') {
      json { text = 'text' }
    }
    then: response.statusCode == NOT_FOUND
    where: method << ['post', 'put']
  }
}
