
public class Consummer extends Thread{
	private Monitor moniteur;
	public Consummer(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		moniteur.retirer();
	}
}