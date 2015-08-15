

public class Data {								//The main data class for This application.
												//Most variables are stored here for ease of access.
	public static int count=0;
	public static int waterCount=0;
	static int rockPosSize = 20;
	static int waterRockPosSize = 20;
	public static int[][] rockPos = new int[rockPosSize][2];						//Array for Rock positions.
	public static int[][] waterRockPos =  new int[waterRockPosSize][2];				//Array for Water Rock positions.
	static int waterRockCurrent = 0;
	static int rockCurrent = 0;
	public static int[] World_Border = new int[2];
	public static int speed = 500;
	public static String text = "";
	public static String oldText = "";
	public static int foundX =0;
	public static int foundY =0;
	
	public static int[] Robot_Pos =  new int[2];
	public static int[] Old_Robot_Pos = new int[2];
	
	public static void initialize(){			//Sets up the data with default values to avoid null pointer references.
		for(int i=0; i<rockPosSize; i++)
		{
			rockPos[i][0] = -1;
			rockPos[i][1] = -1;
		}
		
		for(int i=0; i<waterRockPosSize; i++)
		{
			waterRockPos[i][0] = -1;
			waterRockPos[i][1] = -1;
		}
		
		World_Border[0] = 1;
		World_Border[1] = 1;
	}
	
	public static void addRock(int x, int y)		//Adds a rock to the array for rock positions.
	{
		rockPos[count][0] = x;
		rockPos[count][1] = y;
		count+=1;
	}
	
	public static void addWaterRock(int x, int y)	//Adds a water rock to the array for water rock positions.
	{
		waterRockPos[waterCount][0] = x;
		waterRockPos[waterCount][1] = y;
		waterCount+=1;
	}
	
	public static void updateWorldBorder(int x, int y)	//Updates the world border. 
	{
		World_Border[0] = x;
		World_Border[1] = y;
	}
	
	
	
	
	
}


