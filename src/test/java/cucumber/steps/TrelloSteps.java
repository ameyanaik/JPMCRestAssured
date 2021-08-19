package cucumber.steps;

import org.testng.Assert;

import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TrelloSteps implements En{
	
	RequestSpecification req;
	Response res;
	
	
	public TrelloSteps() {
		
		
		//Given("The Feature File Text", code to execute);
		
		Given("I an authorized on trello", () -> {
		    System.out.println("Inside Given");
		    RestAssured.baseURI = "https://api.trello.com";
		    req = RestAssured	
		    	.given()
		    		.queryParam("key", "9eb6f3fadd887b87328d5d8821218617")
		    		.queryParam("token", "0f34ea679963669930479b91832b99bc2acec34f463b303072d9092b4e014986")
		    		.pathParam("id", "me");
		});
		
		When("I request all boards for the user", () -> {
			System.out.println("Inside When");
			res = req.when()
					.get("/1/members/{id}/boards");
		});

		Then("I receive a valid response", () -> {
			System.out.println("Inside Then");
			res.prettyPrint();
			Assert.assertEquals(res.statusCode(), 200);
		});
	}
}
