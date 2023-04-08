package org.example.polyglot

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value

class JsPolyglot {

  companion object {
    private val context: Context = Context
      .newBuilder("js")
      .build()
  }

  fun execute(jsCode: String): Value {
    return context.eval("js", jsCode)
  }
}
