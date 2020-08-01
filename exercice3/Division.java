package exercice3;

class DivisionParZeroException extends Exception {

	private static final long serialVersionUID = 1L;
	
}

public class Division implements Calculable {

	private Calculable nb1,nb2;
	
	public Division(Calculable nb1, Calculable nb2) {
		this.nb1 = nb1;
		this.nb2 = nb2;
	}
		
	
	@Override
	public void afficher() {
		System.out.println("(" + nb1 + " / " + nb2 + ")");
	}

	@SuppressWarnings("null")
	@Override
	public double calculer() {
		try {
			testZero();
			return nb1.calculer() / nb2.calculer();
		}
		catch(DivisionParZeroException e) {
			System.out.println("division par zéro impossible");
		}
		//Arrêt du programme par un NullPointerException
		return (Double) null;
	}
	
	private void testZero() throws DivisionParZeroException{
		if(nb2.calculer() == 0) throw new DivisionParZeroException(); 
	}
	
	@Override
	public String toString() {
		return String.format("(%s / %s)", nb1, nb2);
	}

}
