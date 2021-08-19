package com.destinationqa.RestAssured.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestBasicAuthenticationPostman {
	
	@Test
	public void basicAuth() {
		
		RestAssured.baseURI = "http://postman-echo.com";
		
		RestAssured
			.given()
				.auth()
					.preemptive() //sends pre-emptively without waiting for challenge
					.basic("postman", "password")
				.log().all()
			.when()
				.get("/basic-auth")
			.then()
				.log().all();
	}
}
