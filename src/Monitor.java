
public class Monitor {

	private String BAL;
	
	private int queue;
	private int tete;
	private int availableWrite;
	private int availableRead;
	
	public Monitor(int taille){
		
		availableWrite = taille;
	}
	
	public synchronized void deposer(Character lettre){
		while(availableWrite != 0){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		BAL += lettre;
		availableWrite -= 1;
		availableRead += 1;
		notifyAll();
	}
	
	public synchronized void retirer(){

		do{
			while(availableRead != 0){
				try{
					wait();
				}catch(InterruptedException e){}
			}
			System.out.println(BAL);
			availableWrite += 1;
			availableRead -= 1;
			notifyAll();
		}while(!BAL.equals("Q"));
	}
	
}