package com.rxf113.vertx_demo.controller;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * controller
 *
 * @author rxf113
 */
@RestController
@RequestMapping(value = "/demo/")
public class DemoController {

  @GetMapping("test")
  public void test(RoutingContext routingContext) {
    //todo 后续简化
    routingContext.response()
      .putHeader("content-type", "application/json; charset=utf-8")
      .end(Json.encodePrettily(new HashMap<>() {{
        put("key", 123);
      }}));
  }
}
