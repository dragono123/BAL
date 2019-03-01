import java.util.Scanner;


public class Productor implements Runnable{
	private Monitor moniteur;
	private Scanner scanner;
	private static int nbProducteur;
	//String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "*"};
	public Productor(Monitor moniteur, Scanner scanner){
		this.moniteur = moniteur;
		this.scanner = scanner;
		nbProducteur = 3;
	}
	
	public void run(){
		String lettre = new String();
		//int i = 0;
		while(!Thread.currentThread().isInterrupted()){
			lettre = getValeur();
			moniteur.deposer(lettre);
			//lettre = lettres[i++];
			
			if(lettre.equals("**") && !(Consummer.nbConsummer > 0 && nbProducteur == 1)){
				nbProducteur--;
				System.out.println("Il reste " + nbProducteur + " producteurs");
				Thread.currentThread().interrupt();
			}
		}
	}
	public synchronized String getValeur(){
		System.out.println("Entrer votre lettre :");
		return scanner.next();
	}
}