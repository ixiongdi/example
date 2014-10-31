//
//  ========================================================================
//  Copyright (c) 1995-2013 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

object Main {
  def main(args: Array[String]) {
    // Create a basic jetty server object that will listen on port 8080.  Note that if you set this to port 0
    // then a randomly available port will be assigned that you can either look in the logs for the port,
    // or programmatically obtain it for use in test cases.
    val server = new Server(8080);

    // The ServletHandler is a dead simple way to create a context handler that is backed by an instance of a
    // Servlet.  This handler then needs to be registered with the Server object.
    val handler = new ServletHandler();

    server.setHandler(handler);

    // Passing in the class for the servlet allows jetty to instantite an instance of that servlet and mount it
    // on a given context path.

    // !! This is a raw Servlet, not a servlet that has been configured through a web.xml or anything like that !!
    handler.addServletWithMapping(HelloServlet.getClass, "/*");

    // Start things up! By using the server.join() the server thread will join with the current thread.
    // See "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()" for more details.
    server.start();
    server.join();
  }

  // @SuppressWarnings("serial")
  object HelloServlet extends HttpServlet {
    // @Override
    override protected def doGet(request: HttpServletRequest, response: HttpServletResponse) {

      // println(request.get)
      // import javax.servlet.http.Cookie
      // val cookies = request.getCookies().toList;
      // println(cookies(0))
      // response.addCookie(new Cookie("name", "xd"))
      // response.setContentType("text/html");
      // response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().println("<h1>Hello SimpleServlet</h1>");
    }
  }
}


/**

grizzly

Running 10s test @ http://127.0.0.1:8080/
  4 threads and 128 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.14ms    2.16ms  76.39ms   91.42%
    Req/Sec    11.01k     1.51k   16.33k    80.85%
  Latency Distribution
     50%    2.82ms
     75%    3.17ms
     90%    4.23ms
     99%   12.02ms
  416586 requests in 10.00s, 472.40MB read
  Non-2xx or 3xx responses: 416586
Requests/sec:  41662.09
Transfer/sec:     47.24MB


serlet

Running 10s test @ http://127.0.0.1:8080/
  4 threads and 128 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.49ms   24.31ms 457.80ms   99.10%
    Req/Sec    25.87k     3.36k   54.89k    90.04%
  Latency Distribution
     50%  580.00us
     75%    1.05ms
     90%    1.30ms
     99%   20.26ms
  967976 requests in 10.00s, 126.47MB read
Requests/sec:  96841.73
Transfer/sec:     12.65MB

untordon

Running 10s test @ http://127.0.0.1:8080/
  4 threads and 128 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   703.27us    3.49ms 207.01ms   99.46%
    Req/Sec    46.38k    11.34k  103.22k    76.00%
  Latency Distribution
     50%  573.00us
     75%  663.00us
     90%    0.99ms
     99%    3.13ms
  1738243 requests in 9.99s, 184.01MB read
Requests/sec: 173912.79
Transfer/sec:     18.41MB


*/