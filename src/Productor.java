import java.util.Scanner;


public class Productor extends Thread{
	private Monitor moniteur;
	public Productor(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		String lettre = new String();
		while(!this.isInterrupted()){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Entrer votre lettre :");
			lettre = scanner.next();
			for(int i = 0; i < lettre.length(); i++){
				moniteur.deposer(lettre.charAt(i));
				if(lettre.charAt(i) == 'Q'){
					this.interrupt();
					break;
				}
			}
		}
	}
}