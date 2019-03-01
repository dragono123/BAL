import java.util.Scanner;


public class Productor implements Runnable{
	private Monitor moniteur;
	public Productor(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		String lettre = new String();
		int i = 0;
		String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "*"};
		while(!Thread.currentThread().isInterrupted()){
			/*Scanner scanner = new Scanner(System.in);
			System.out.println("Entrer votre lettre :");
			lettre = scanner.next();
			moniteur.deposer(lettre);*/
			lettre = lettres[i++];
			moniteur.deposer(lettre);
			
			if(lettre.equals("*")){
				Thread.currentThread().interrupt();
			}
		}
	}
}