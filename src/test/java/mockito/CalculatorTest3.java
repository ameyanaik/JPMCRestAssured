package mockito;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest3 {
	
	@Mock
	Calculator calc, calc2, calc3;
	
	@Mock
	ArrayList<String> myarray;
	
	@BeforeTest
	public void setUpMocks() {
		//calc = Mockito.mock(Calculator.class);
		MockitoAnnotations.openMocks(this);
		Mockito.when(calc.add(2, 3)).thenReturn(5);
		Mockito.when(calc.add(-2, -3)).thenReturn(-5);
		//Mockito.when(calc.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(100);
		
		Mockito.when(myarray.add("Ameya")).thenReturn(true);
	}
	
	@Test
	public void testAddition() {
		int result = calc.add(2,3);
		Assert.assertEquals(result, 5);
		Assert.assertEquals(calc.add(-2, -3), -5);
		//Assert.assertEquals(calc.add(30, 40), 100);
		
		Assert.assertEquals(calc.subtract(10, 7), 3);
		
		Assert.assertTrue(myarray.add("Ameya"));
	}

}
