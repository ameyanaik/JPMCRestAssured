package com.destinationqa.RestAssured.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestImgurWithClientID {
	
	@Test
	public void testImgur() {
		
		RestAssured.baseURI = "https://api.imgur.com/3";
		
		Response res = RestAssured
			.given()
				.header("Authorization", "Client-ID ef9625f9bce0f6e")
			.when()
				.get("/gallery/top/week/1")
			.then()
				.extract().response();
		System.out.print("Number of Images Found: ");
		System.out.println(res.jsonPath().getList("data").size());
		
	}

}
