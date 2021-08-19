package mockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest {
	
	@Test
	public void testAddition() {
		
		//Calculator calc = new Calculator();
		
		Calculator calc = Mockito.mock(Calculator.class);
		Mockito.when(calc.add(2, 3)).thenReturn(5);
		
		
		
		int result = calc.add(2,3);
		Assert.assertEquals(result, 5);
		
	}

}
