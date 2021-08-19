package com.destinationqa.RestAssured.authentication;

import io.restassured.RestAssured;

public class PUTOAuth2ImgurUpdateUsername {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.imgur.com";
		
		RestAssured	
			.given()
				.auth()
					.oauth2("<Your provate token>")
				.pathParam("username", "ameyanaik1")
				.formParam("username", "ameyanaik")
				.log().headers()
			.when()
				.put("/3/account/{username}/settings")
			.then()
				.log().body();
			
		
	}

}
