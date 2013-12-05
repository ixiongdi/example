import io.undertow.server._
import io.undertow.util.Headers;
import io.undertow.Undertow

object Main3 {

  def main(args: Array[String]) {
    val server = Undertow.builder()
      .addListener(8080, "localhost")
      .setHandler(new HttpHandler() {
        override def handleRequest(exchange: HttpServerExchange) {
          exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
          exchange.getResponseSender().send("Hello World");
        }
      }).build();
    server.start();
  }
}

// package net.imiui.http

// object Server extends Undertow {

//     def get(url: String)() = {
//         new HttpHandler(url) {

//         }
//     }
// }