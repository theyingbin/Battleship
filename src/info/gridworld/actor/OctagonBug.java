package info.gridworld.actor;
import java.awt.Color;

public class OctagonBug extends BoxBug{
	public OctagonBug(int number){
		super(number);
	}
	public OctagonBug(int number, Color bugColor){
		super(number,bugColor);
	}
	public void act(){
		if(getCounter()!=getSideLength()){
			if (canMove())
	            move();
	        else
	            turn();
			setCounter(getCounter()+1);
		}
		else{
			setCounter(1);
			turn();
		}
	}
}