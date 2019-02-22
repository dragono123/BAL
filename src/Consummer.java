
public class Consummer extends Thread{
	private Monitor moniteur;
	public Consummer(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		while(!isInterrupted()){
			if(moniteur.retirer() == 'Q'){
				this.interrupt();
			}
		}
	}
}