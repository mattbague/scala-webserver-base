package com.mattbague.swb.server.api

import colossus.protocols.http.{HttpRequest, HttpResponse}

class HelloWorldRestService extends Endpoint {
  override def get(request: HttpRequest, pathParam: Option[String]): HttpResponse = {
    request.ok("Hello world!")
  }
}
