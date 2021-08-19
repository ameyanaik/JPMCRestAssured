package trello.functions;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import trello.common.Base;

public class TrelloMembers extends Base{

	public static List<String> getBoardNamesForThisMember() {
		
		String resourcepath = "/1/members/{id}/boards";
		
		List<String> names = RestAssured
			.given()
				.spec(commonspec)
				.pathParam("id", "me")
			.when()
				.get(resourcepath)
			.then()
				//.log().all()
				.extract().response()
				.jsonPath().getList("name");
		
		return names;
	}

	public static String getFirstBoardID() {
		
		String resourcepath = "/1/members/{id}/boards";
		
		Response res = RestAssured
		.given()
			.spec(commonspec)
			.pathParam("id", "me")
		.when()
			.get(resourcepath);
			
		return res.body().jsonPath().getString("[0].id");
	}
}
