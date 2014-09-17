package threadSharingVariable;

public class WritingThread implements Runnable{

	private CommonClass commonClass;
	
	public WritingThread(CommonClass commonClass){
		this.commonClass = commonClass;
	}
	
	@Override
	public void run() {
		
		System.out.println("Writing Thread");
		
		boolean status;
		
		while(true){
		
			try {
				Thread.sleep(Long.valueOf(10000));
				status = commonClass.read();
				if(status == true){
					commonClass.write(false);
				}else{
					commonClass.write(true);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
