import com.irs.jam.*;

class Runner extends Thread		//Creates a Thread for the UI.
{								//This is currently not used.
	public void run()
	{
		UI ui = new UI();
		ui.main(null);
	}
	
}


class Runner2 extends Thread	//Creates a thread for the jam agent.
{								//So that the UI can interact with the jam agent while its running
	public void run()
	{
		JamController.setup("robotpos.jam");
	}
	

}





public class Main {

	public Runner2 runner2 = new Runner2();			
	
	public static void main(String[] args)
	{
		
		
		Runner runner1 = new Runner();
		runner1.start();
			
	}
	
	public  void jam()			//Starts the jam agent. Called to by the UI.
	{
		
		runner2.start();
	}
	
	

	
	
	
	
}
