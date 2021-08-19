package trello.functions;

import io.restassured.RestAssured;
import trello.common.Base;

public class Boards extends Base{

	public static boolean deleteBoard(String boardid) {
		
		String resourcepath = "/1/boards/{id}";
		
		int statuscode = RestAssured
			.given()
				.spec(commonspec)
				.pathParam("id", boardid)
			.when()
				.delete(resourcepath)
			.then()
				.extract().response().statusCode();
			
		if(statuscode == 200) { 
			return true;
		} else {
			return false;
		}
	}
}
