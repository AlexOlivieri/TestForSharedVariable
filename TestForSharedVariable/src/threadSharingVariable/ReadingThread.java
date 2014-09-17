package threadSharingVariable;

public class ReadingThread implements Runnable{

private CommonClass commonClass;
	
	public ReadingThread(CommonClass commonClass){
		this.commonClass = commonClass;
	}
	
	@Override
	public void run() {
		
		System.out.println("Reading Thread");
		
		boolean status;
		
		while(true){
		
			try {
				Thread.sleep(Long.valueOf(3000));
				status = commonClass.read();
				System.out.println(status);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}		
}
