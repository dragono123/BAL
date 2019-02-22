
public class Test {
	public static void main(String[] args){
		Monitor moniteur = new Monitor();
		Productor producteur = new Productor(moniteur);
		Consummer consommeur = new Consummer(moniteur);
		producteur.start();
		consommeur.start();
	}
}
