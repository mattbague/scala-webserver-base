package com.mattbague.swb.server.wiring

import com.mattbague.swb.server.api.{HelloNameRestService, HelloWorldRestService}

class RestServiceWiring {

  val helloWorldRestService = new HelloWorldRestService

  val helloNameRestService = new HelloNameRestService
}
