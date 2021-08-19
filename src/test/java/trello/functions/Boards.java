package trello.functions;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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

	public static String createBoardAndReturnID(String name) {

		Response res = RestAssured
		.given()
			.spec(commonspec)
			.queryParam("name", name)
		.when()
			.post("/1/boards/");
		
		return res.jsonPath().getString("id");
	}

	public static String getListIDByListName(String listname, String boardid) {
		
		String todolistid = null;
		
		String resourcepath = "/1/boards/{id}/lists";
		
		Response res = RestAssured
				.given()
					.spec(commonspec)
					.pathParam("id", boardid)
				.when()
					.get(resourcepath)
				.then()
					//.log().all()
					.extract().response();
		
		List<Map<String,String>> lists = res.jsonPath().getList("");
		for (Map<String, String> list : lists) {
			if(list.get("name").equals(listname)) {
				todolistid = list.get("id");
			}
		}
		
		return todolistid;
	}

	public static String getBoardIDByName(String boardname) {

			
		
		return null;
	}
}
