import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Monitor {

	private BlockingQueue<String> buffer;

		
	public Monitor(int taille){
		buffer = new LinkedBlockingQueue<String>(taille);
	}
	
	public void deposer(String lettre){
		try {
			buffer.put(lettre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String retirer(){
		String lettre = new String();
		try {
			lettre = buffer.take();
			System.out.println(lettre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return lettre;
	}
}