package com.example.grizzly

import org.glassfish.grizzly.http.server._

object Main {
  def main(args: Array[String]): Unit = {
    val server = HttpServer.createSimpleServer();
    server.getServerConfiguration().addHttpHandler(
      new HttpHandler() {
        def service(request: Request, response: Response) {
          val date = "hello"
          // response.setContentType("text/plain");
          // response.setContentLength(date.length());
          response.getWriter().write(date);
        }
      },
      "/time");
    server.start();
    System.out.println("Press any key to stop the server...");
    System.in.read();
  }
}
