package trello.functions;

import java.util.List;
import java.util.Map;

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

	public static String getBoardIDByName(String boardname) {

		String resourcepath = "/1/members/{id}/boards";
		String boardid = null;
		
		Response res = RestAssured
			.given()
				.spec(commonspec)
				.pathParam("id", "me")
			.when()
				.get(resourcepath);
		
		List<Map<String,?>> boards = res.jsonPath().getList("$");
		
		for (Map<String, ?> board : boards) {
			if(board.get("name").equals(boardname)) {
				boardid = (String) board.get("id");
			}
		}
		return boardid;
	}
}
