
public class Test {
	public static void main(String[] args){
		Monitor moniteur = new Monitor(5);
		Productor producteur = new Productor(moniteur);
		Consummer consommeur = new Consummer(moniteur);
		Thread producteurs = new Thread(producteur);
		Thread consommeurs = new Thread(consommeur);
		producteurs.start();
		consommeurs.start();
	}
}
