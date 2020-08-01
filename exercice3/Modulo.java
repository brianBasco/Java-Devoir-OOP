package exercice3;

class ModuloParZeroException extends Exception {

	private static final long serialVersionUID = 1L;
	
}

public class Modulo implements Calculable {

	private Calculable nb1,nb2;
	
	public Modulo(Calculable nb1, Calculable nb2) {
		this.nb1 = nb1;
		this.nb2 = nb2;
	}
	
	@Override
	public void afficher() {
		System.out.println("(" + nb1 + " % " + nb2 + ")");
	}

	@SuppressWarnings("null")
	@Override
	public double calculer() {
		try {
			testZero();
			return nb1.calculer() % nb2.calculer();
		}
		catch(ModuloParZeroException e) {
			System.out.println("modulo par zéro impossible");
		}
		return (Double) null;
	}
	
	private void testZero() throws ModuloParZeroException{
		if(nb2.calculer() == 0) throw new ModuloParZeroException(); 
	}

	@Override
	public String toString() {
		return "(" + nb1 + " % " + nb2 + ")";
	}
}