package trello.functions;

import org.omg.CORBA.COMM_FAILURE;

import io.restassured.RestAssured;
import trello.common.Base;

public class Cards extends Base {

	public static int addNewCardToList(String todolistid, String cardtitle) {
		
		return RestAssured
			.given()
				.spec(commonspec)
				.queryParam("idList", todolistid)
				.queryParam("name", cardtitle)
			.when()
				.post("/1/cards")
			.then()
				.extract().response().statusCode();
	}

}
