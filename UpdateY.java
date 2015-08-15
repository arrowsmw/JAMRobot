import com.irs.jam.*;

public class UpdateY implements PrimitiveAction
{
	public Value execute(String name, int arity, ExpList args, Binding binding, Goal currentGoal)				//Is sent the robots Y position from jam agent.
	{
		ExpListEnumerator ele = new ExpListEnumerator(args);
		Expression exp;
		
		while((exp = (Expression) ele.nextElement()) !=null)
		{
			if(exp.eval(binding).type() == Value.VAL_LONG)
			{
				Data.Robot_Pos[1] = ((int)exp.eval(binding).getLong());			//Y position is converted to int and passed to data class.							
			}
		}
		return Value.TRUE;
	}
}