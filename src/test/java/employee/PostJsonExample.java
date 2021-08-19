package employee;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostJsonExample {
	
	@Test
	public void testCreateEmployeeWithStringBody() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		
		String resourcepath = "/api/v1/create";
		
		RestAssured
			.given()
				.body("{\"name\":\"Ameya\",\"salary\":\"10000\",\"age\":\"30\"}")
			.when()
				.post(resourcepath)
			.then()
				.log().all()
				.assertThat().statusCode(200);
	}
	
	
	@Test
	public void testCreateEmployeeWithJSONObject() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		
		String resourcepath = "/api/v1/create";
		JSONObject payload = new JSONObject();
		
		payload.put("name", "Ameya");
		payload.put("age", "30");
		payload.put("salary", "10000");
		
		RestAssured
		.given()
			.body(payload.toString())
		.when()
			.post(resourcepath)
		.then()
			.log().all()
			.assertThat().statusCode(200)
			.assertThat().body("status", Matchers.equalTo("success"));
		
	}

}
