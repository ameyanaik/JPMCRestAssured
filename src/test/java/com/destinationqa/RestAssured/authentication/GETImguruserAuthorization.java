package com.destinationqa.RestAssured.authentication;

import io.restassured.RestAssured;

public class GETImguruserAuthorization {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.imgur.com";
		
		RestAssured
			.given()
				.queryParam("client_id", "ef9625f9bce0f6e")
				.queryParam("response_type", "token")
			.when()
				.get("/oauth2/authorize")
			.then()
				.log().body();
		
	}

}
