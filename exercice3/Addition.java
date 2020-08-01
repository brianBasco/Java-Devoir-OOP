package exercice3;

public class Addition implements Calculable {

	private Calculable nb1,nb2;
	
	public Addition(Calculable nb1, Calculable nb2) {
		this.nb1 = nb1;
		this.nb2 = nb2;
	}
			
	@Override
	public void afficher() {
		/*
		nb1.afficher();
		System.out.println("+");
		nb2.afficher();
		*/
		System.out.println("("+ nb1 + " + " + nb2 + ")");
	}

	
	@Override
	public double calculer() {
		return nb1.calculer() + nb2.calculer();
	}
	
	@Override
	public String toString() {
		return String.format("(%s + %s)", nb1,nb2);
	}
	

}
