
public class Monitor {

	private String BAL;
	
	private boolean available;
	
	public Monitor(){
		available = false; //Par défaut, il n'y a rien à lire
	}
	
	public synchronized void deposer(String lettre){
		while(available == true){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		BAL = lettre; 
		available = true;
		notifyAll();
	}
	
	public synchronized void retirer(){

		do{
			while(available == false){
				try{
					wait();
				}catch(InterruptedException e){}
			}
			System.out.println(BAL);
			available = false;
			notifyAll();
		}while(!BAL.equals("Q"));
	}
	
}