package threadSharingVariable;

import java.util.concurrent.atomic.AtomicBoolean;

public class CommonClass {

	private AtomicBoolean sharedVariable;
	
	public CommonClass(){
		sharedVariable = new AtomicBoolean(true);
		
	}
	
	public void play(){
		
		System.out.println("Play");
		
		new Thread(new WritingThread(this)).start();
		new Thread(new ReadingThread(this)).start();
		
	}
	
	public synchronized void write(boolean value){
		
		sharedVariable.getAndSet(value);
	}
	
	public synchronized boolean read(){
		
		return sharedVariable.get();
	}
	
	
}
