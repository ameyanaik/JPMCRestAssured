package mockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest2 {
	
	Calculator calc;
	
	@BeforeTest
	public void setUpMocks() {
		calc = Mockito.mock(Calculator.class);
		Mockito.when(calc.add(2, 3)).thenReturn(5);
		Mockito.when(calc.add(-2, -3)).thenReturn(-5);
		//Mockito.when(calc.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(100);
	}
	
	@Test
	public void testAddition() {
		int result = calc.add(2,3);
		Assert.assertEquals(result, 5);
		Assert.assertEquals(calc.add(-2, -3), -5);
		Assert.assertEquals(calc.add(30, 40), 100);
	}

}
