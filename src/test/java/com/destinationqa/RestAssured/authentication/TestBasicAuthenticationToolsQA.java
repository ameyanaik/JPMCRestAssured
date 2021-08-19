package com.destinationqa.RestAssured.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestBasicAuthenticationToolsQA {
	
	//@Test
	public void basicAuth() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		
		RestAssured
			.given()
				.auth()
					.preemptive() //sends pre-emptively without waiting for challenge
					.basic("ToolsQA", "TestPassword")
				.log().all()
			.when()
				.get("/authentication/CheckForAuthentication")
			.then()
				.log().all();
		
	}

}
