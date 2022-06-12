# springmvc-2-vertx

尝试下，用springmvc的方式来定义vertx接口。

举例: 自己编写代码，定义接口依旧用 springmvc 的方式

```java
  @GetMapping("/test")
  public Object test(@RequestParam(value = "val") String val){
    System.out.println(val);
    return"success!"+val;
  }
```

项目启动时会动态将上面的定义方式转化为 vertx 的方式。
例如上面这个代码，实际等价于下面这个

```java
    router.get("/test").handler(routingContext -> {
        String val = routingContext.request().getParam("val");
        System.out.println(val);
        routingContext.response()
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(Json.encodePrettily("success!" + val));
    });
```
