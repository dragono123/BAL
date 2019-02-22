
public class Consummer extends Thread{
	private Monitor moniteur;
	public Consummer(Monitor moniteur){
		this.moniteur = moniteur;
	}
	
	public void run(){
		while(!isInterrupted()){
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(moniteur.retirer() == 'Q'){
				this.interrupt();
			}
		}
	}
}