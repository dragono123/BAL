import java.util.Scanner;


public class Productor extends Thread{
	private Monitor moniteur;
	public Productor(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		String lettre = new String();
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Entrer votre lettre :");
			lettre = scanner.next();
			moniteur.deposer(lettre);
		}while(!lettre.equals("Q"));
	}
}