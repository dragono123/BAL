
public class Consummer implements Runnable{
	private Monitor moniteur;
	public static int nbConsummer;
	public Consummer(Monitor moniteur){
		this.moniteur = moniteur;
		nbConsummer = 3;
	}
	
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(moniteur.retirer().equals("*")){
				nbConsummer--;
				System.out.println("Il reste " + nbConsummer + " consommateurs.");
				Thread.currentThread().interrupt();
			}
		}
	}
}