
public class Monitor {

	private String BAL;
	
	private int queue;
	private int tete;
	private int availableWrite;
	private int availableRead;
	private int TAILLE;
	
	public Monitor(int taille){
		TAILLE = taille;
		availableWrite = taille;
		availableRead = 0;
		BAL = "##########";
	}
	
	public synchronized void deposer(Character lettre){
		while(availableWrite == 0){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		StringBuilder balBuilder = new StringBuilder(BAL);
		balBuilder.setCharAt(tete, lettre);
		BAL = balBuilder.toString();
		availableWrite -= 1;
		availableRead += 1;
		tete = (tete + 1)%TAILLE;
		notifyAll();
	}
	
	public synchronized Character retirer(){

		while(availableRead == 0){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		Character lettre = BAL.charAt(queue);
		System.out.print(lettre);
		availableWrite += 1;
		availableRead -= 1;
		queue = (queue + 1)%TAILLE;
		notifyAll();
		return lettre;
	}
	
}