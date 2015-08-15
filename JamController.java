import com.irs.jam.*;
import com.irs.jam.examples.*;
public class JamController {
	

	public static Interpreter i1 = null;
	public static Binding binding = null;
	public static String string = "s";
	public static int[][] rocks = new int[10][10];
	public static JAM jamAgent = new JAM();
	static boolean retVal;
	
	

	
	
    public static void setup(String Jamagent)
    {
        
        String agent[] = { Jamagent };	//sets the jam agent to be run
        
        
        
        
        
        
       
        

        try {
            i1 = new Interpreter(agent);		//attempts to initialize the jam agent.

        }
        catch (Exception e) {
            System.out.println("Error parsing file " + agent[0] + ".");
        }
        
        retVal = jamAgent.think(i1);			//runs the jam agent.
        
        
       
        
     
        jamAgent.myStop();						//stops jam agent when top level goal complete.
        
    }
    

    
    

   
    
    public static void passRock(int num)		//Passes current rock values to Jam
    {    	
    	String string = "FACTS: FACT Rock " + Data.rockPos[num][0] + " " + Data.rockPos[num][1] + ";";
    	
    	ExpList ex1 = new ExpList();
        ex1.append(new Value(string));
        Relation oldRel2 = new Relation("string", ex1, i1);
        i1.getWorldModel().Assert(oldRel2, binding);
    }
    
    public static void passWaterRock(int num)		//Passes current water rock values to Jam.
    {
    	String string = "FACTS: FACT Water_Rock " + Data.waterRockPos[num][0] + " " + Data.waterRockPos[num][1] + ";";
    	
    	ExpList ex = new ExpList();
    	ex.append(new Value(string));
    	Relation newRel = new Relation("string", ex, i1);
    	i1.getWorldModel().Assert(newRel, binding);
    }
    
    public static void getCount()				//Passes number of rocks in Data class to Jam.
    {
    	ExpList ex = new ExpList();
    	ex.append(new Value(Data.count));
    	Relation newRel = new Relation("Count", ex, i1);
    	i1.getWorldModel().Assert(newRel, binding);
    }
    
    public static void getWaterCount()			//Passes number of water rocks in Data class to Jam.
    {
    	ExpList ex = new ExpList();
    	ex.append(new Value(Data.waterCount));
    	Relation newRel = new Relation("Water_Count", ex, i1);
    	i1.getWorldModel().Assert(newRel, binding);
    }
    
    public static void getWorldBorder()			//Passes the values for the world border to Jam.
    {
    	String string = "FACTS: FACT World_Border " + Data.World_Border[0] + " " + Data.World_Border[1] + ";";
    	
    	ExpList ex = new ExpList();
    	ex.append(new Value(string));
    	Relation newRel = new Relation("string", ex, i1);
    	i1.getWorldModel().Assert(newRel, binding);
    }
    
    public static void updateSpeed()			//Passes the variable for the update speed to Jam.
    {
    	ExpList ex = new ExpList();
    	ex.append(new Value(Data.speed));
    	Relation newRel = new Relation("Speed", ex, i1);
    	Relation oldRel = new Relation("Speed", i1);
    	i1.getWorldModel().update(oldRel, newRel, binding);	
    }
    
    public static void updateText(String text)	//Function for Jam to call when it wants to add text to the GUI.
    {
    	Data.text = text;
    }
    
    public static void updatePos(int x, int y)	//Function for Jam to print the robot positon of the screen.
    {
    	Data.text = "The Robot is at: (" + x + "," + y + ").\n";
    }
    
    public static void removeRock(int x, int y)	//Removes a rock from the Data array. Called by Jam.
    {
    	for(int i=0; i<Data.count; i++)
    	{
    		if(Data.rockPos[i][0] == x && Data.rockPos[i][1] == y)
    		{
    			
    			Data.rockPos[i][0] = -1;
    			Data.rockPos[i][1] = -1;
    			
    		}
    	}
    }
    
    public static void foundWater(int x, int y)		//Passes the position of the water rock found. Called by Jam.
    {
    	for(int i=0; i<Data.waterCount; i++)
    	{
    		if(Data.waterRockPos[i][0] == x && Data.waterRockPos[i][1] == y)
    		{
    			Data.waterRockPos[i][0] = -1;
    			Data.waterRockPos[i][1] = -1;
    			
    		}
    	}
    	Data.foundX = x;
    	Data.foundY = y;
    }
    
}

