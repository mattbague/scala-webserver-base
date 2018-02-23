package com.mattbague.swb.server.api

import colossus.protocols.http.HttpMethod._
import colossus.protocols.http.{HttpRequest, HttpResponse}

trait Endpoint {

  final def handle(request: HttpRequest, pathParam: Option[String]): HttpResponse = {
    request.head.method match {
      case Get => get(request, pathParam)
      case Post => post(request, pathParam)
      case Put => put(request, pathParam)
      case Delete => delete(request, pathParam)
      case Head => head(request, pathParam)
      case Options => options(request, pathParam)
      case Trace => trace(request, pathParam)
      case Connect => connect(request, pathParam)
      case Patch => patch(request, pathParam)
    }
  }

  def get(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("get unsupported")

  def post(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("post unsupported")

  def put(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("put unsupported")

  def delete(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("delete unsupported")

  def head(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("head unsupported")

  def options(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("options unsupported")

  def trace(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("trace unsupported")

  def connect(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("connect unsupported")

  def patch(request: HttpRequest, pathParam: Option[String]): HttpResponse = throw new UnsupportedOperationException("patch unsupported")
}
