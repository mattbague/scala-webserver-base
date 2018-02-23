package com.mattbague.swb.server.api

import colossus.protocols.http.{HttpRequest, HttpResponse}

class HelloNameRestService extends Endpoint {
  override def get(request: HttpRequest, pathParam: Option[String]): HttpResponse = {
    val name = pathParam.getOrElse("Unknown")
    request.ok(s"Hello $name!")
  }
}
