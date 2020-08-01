package exercice3;

public class Multiplication implements Calculable {

	private Calculable nb1,nb2;
	
	public Multiplication(Calculable nb1, Calculable nb2) {
		this.nb1 = nb1;
		this.nb2 = nb2;
	}
	
	@Override
	public void afficher() {
		System.out.println("(" + nb1 + " * " + nb2 + ")");
	}

	@Override
	public double calculer() {
		return nb1.calculer() * nb2.calculer();
	}
	
	@Override
	public String toString() {
		return "(" + nb1 + " * " + nb2 + ")";
	}

}

