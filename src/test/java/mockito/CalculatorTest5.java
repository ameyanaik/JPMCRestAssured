package mockito;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;
import io.restassured.response.Response;

public class CalculatorTest5 {
	
	@Spy
	Calculator calc;
	
	@Spy
	Response res;
	
	
	@BeforeTest
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		Mockito.when(calc.add(2, 3)).thenReturn(5);
		Mockito.when(calc.subtract(10,7)).thenReturn(2);
		
		Mockito.when(res.body().jsonPath().get("id")).thenReturn("769t298745237854y");
		//calc = new Calculator();
	}
	
	@Test
	public void testCalculator() {
		
		int result = calc.add(2, 3);
		Assert.assertEquals(result, 5);
		
		result = calc.subtract(5, 3);
		Assert.assertEquals(result, 2);
		
		result = calc.subtract(10, 7);
		Assert.assertEquals(result, 3);
	}

}
