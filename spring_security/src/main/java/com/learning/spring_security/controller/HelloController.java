package com.learning.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/**
	 * <li>Using Basic authentication involves sending a verified username and
	 * password with your request. In the request Headers, the Authorization header
	 * passes the API a Base64 encoded string representing your
	 * {@code username:password} appended to the text "Basic" as follows:
	 * {@code Basic <Base64 encoded "username:password">}<br>
	 * <br>
	 * <strong>url:</strong> {@code curl -u user:<i>password</i>
	 * http://localhost:8080/hello } <br>
	 * OR <br>
	 * <strong>url:</strong> {@code curl -H "Authorization: Basic
	 * dXNlcjoxMWM0YTFiMy01NGRjLTQyNjctODE0Yy1hZjQ3MjRkZjQ3NWI="
	 * http://localhost:8080/hello} <br>
	 * <br>
	 * <li>In 2nd command the user:password combination is encoded to base-64 by the
	 * used and passed using -H(which adds them directly to the headers).<br>
	 * <li>The 1st command encodes the {@code user:password} combination, appends it
	 * to "Basic " and then adds it to header as a value for key
	 * {@code Authorization}. All this happens behind the scene because of using
	 * {@code -u}<br>
	 * <hr>
	 * <li>HTTPS combines HTTP with Transport Layer Security (TLS) or Secure Sockets
	 * Layer (SSL) to establish an encrypted connection between a browser or app and
	 * a website.
	 * <li>Here after enabling the SSL we called this endpoint using</li>
	 * <strong>url:</strong>
	 * {@code curl -k -u user:a13a65eb-1629-4e06-8f45-a564bd84ea56 https://localhost:8080/hello}<br>
	 * <br>
	 * 
	 * 
	 * <strong>At this stage only <i>curl -k -u admin:password
	 * https://localhost:8080/hello</i> will be able to get the response and all
	 * other calls will fail due to lack of default UserName:Password
	 * combination</strong>
	 * <hr>
	 * @apiNote Use {@code https://www.base64encode.net/} to encode and decode
	 * 
	 */
	@GetMapping("/hello")
	String hello() {
		return "Hello";
	}
}