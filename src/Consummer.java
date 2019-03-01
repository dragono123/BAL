
public class Consummer implements Runnable{
	private Monitor moniteur;
	public Consummer(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(moniteur.retirer().equals("*")){
				Thread.currentThread().interrupt();
			}
		}
	}
}