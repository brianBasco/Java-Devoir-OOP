package exercice3;

public class Main {

public static void main(String[] args) {
		
		Calculable nb1 = new Nombre(3.0);
		Calculable nb3 = new Addition(new Nombre(4.0), new Nombre(7.0));
		
		Calculable add = new Addition(nb1, nb3);
		add.afficher();
		Calculable res = new Nombre(add.calculer());
		res.afficher();
		Calculable signe = new ChgtSigne(res);
		signe.afficher();
		
		Calculable div = new Division(res, new Nombre(5));
		div.calculer();
		div.afficher();
		res = new Nombre(div.calculer());
		res.afficher();
		
		Calculable sin = new Sinus(new Nombre(90));
		sin.afficher();
		System.out.println(sin.calculer());
	}

}
