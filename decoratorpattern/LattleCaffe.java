package decoratorpattern;

public class LattleCaffe extends Beverage {

	public LattleCaffe(){
		description = "LattleCaffe"; //description�����̳���Beverage
	}
	@Override
	public double cost() {
		return 2.00;
	}

}
