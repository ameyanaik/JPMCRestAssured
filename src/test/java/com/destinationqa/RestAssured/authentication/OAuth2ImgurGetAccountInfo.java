package com.destinationqa.RestAssured.authentication;

import io.restassured.RestAssured;

public class OAuth2ImgurGetAccountInfo {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.imgur.com";
		
		RestAssured	
			.given()
				.auth()
					.oauth2("<Your provate token>")
				.pathParam("username", "ameyanaik")
				.log().all()
			.when()
				.get("/3/account/{username}")
			.then()
				.log().all();
	}

}
