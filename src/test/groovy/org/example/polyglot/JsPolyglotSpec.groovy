package org.example.polyglot

import org.graalvm.polyglot.Value
import spock.lang.Specification

class JsPolyglotSpec extends Specification {

  def "test the value returned by a js function"() {
    given:
    String jsFunction = """
      |function square(x) {
      |  return x * x; 
      |}""".stripMargin()
    String jsFunctionCall = "square(2)"

    when:
    new JsPolyglot().execute(jsFunction)
    Value value = new JsPolyglot().execute(jsFunctionCall)

    then:
    value.isNumber()
    value.asInt() == 4
  }
}
