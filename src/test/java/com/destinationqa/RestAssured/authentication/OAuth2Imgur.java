package com.destinationqa.RestAssured.authentication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2Imgur {

	
	//@BeforeMethod
	public void setUpToken() {
		RestAssured.baseURI = "https://api.imgur.com";
		
		RestAssured	
			.given()
				.formParam("refresh_token", "<Your Private Token>")
				.formParam("client_id", "<Your Private client id>")
				.formParam("client_secret", "<Your Private client secret>")
				.formParam("grant_type", "refresh_token")
			.when()
				.post("/oauth2/token")
			.then()
				.log().body();	
	}
	
	@Test
	public void testImgurFavorites() {
		
		RestAssured.baseURI = "https://api.imgur.com";
		
		
		Response res = RestAssured	
			.given()
				.auth()
					.oauth2("<Token extracted in Setup>")
				.pathParam("username", "ameyanaik")
				.log().headers()
			.when()
				.get("/3/account/{username}/favorites")
			.then()
				.log().body()
				.extract().response();
		
		if(res.getStatusCode()!= 200) {
			setUpToken();
		}
	}
	

}
