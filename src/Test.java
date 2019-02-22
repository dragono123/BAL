
public class Test {
	public static void main(String[] args){
		Monitor moniteur = new Monitor(10);
		Productor producteur = new Productor(moniteur);
		Consummer consommeur = new Consummer(moniteur);
		producteur.start();
		consommeur.start();
	}
}
