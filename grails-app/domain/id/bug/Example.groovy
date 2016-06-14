package id.bug

import grails.rest.Resource

@Resource(uri='/examples', formats=['json']) class Example {
  String text
  static constraints = {}
}
