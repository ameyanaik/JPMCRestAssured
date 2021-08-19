package app;

public class Calculator implements CalculatorInterface{

	@Override
	public int add(int a, int b) {      //NOT IMPLEMENTED - Use MOCK
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int subtract(int a, int b) {  //PARTIALLY IMPLEMENTED - Use SPY
		// TODO Auto-generated method stub
		return a-b;
	}

}
