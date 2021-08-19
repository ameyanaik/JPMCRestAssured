package com.destinationqa.RestAssured.authentication;

import io.restassured.RestAssured;

public class RefreshTokenImgur {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.imgur.com";
		
		RestAssured	
			.given()
				.formParam("refresh_token", "<Your private token>")
				.formParam("client_id", "<Your private client id>")
				.formParam("client_secret", "<Your private client secret>")
				.formParam("grant_type", "refresh_token")
			.when()
				.post("/oauth2/token")
			.then()
				.log().body();	
	}
}
