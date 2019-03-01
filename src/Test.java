import java.util.Scanner;


public class Test {
	public static void main(String[] args){
		Monitor moniteur = new Monitor(5);
		Scanner scanner = new Scanner(System.in);
		Productor producteur = new Productor(moniteur, scanner);
		Consummer consommeur = new Consummer(moniteur);
		Thread[] producteurs = new Thread[3];
		Thread[] consommeurs = new Thread[3];
		
		for(int i = 0; i < 3; i++)
			consommeurs[i] = new Thread(producteur);
		for(int i = 0; i < 3; i++)
			consommeurs[i].start();
		for(int i = 0; i < 3; i++)
			producteurs[i] = new Thread(consommeur);
		for(int i = 0; i < 3; i++)
			producteurs[i].start();
	}
}
