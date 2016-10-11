package info.gridworld.actor;
import java.awt.Color;

public class BoxBug extends Bug{
	private int sideLength;
	private int counter;
	
	public BoxBug(int number){
		super();
		counter=1;
		sideLength=number;
	}
	public BoxBug(int number, Color bugColor){
		super(bugColor);
		counter=1;
		sideLength=number;
	}
	public int getSideLength(){
		return sideLength;
	}
	public int getCounter(){
		return counter;
	}
	public void setSideLength(int number){
		sideLength=number;
	}
	public void setCounter(int counter){
		this.counter=counter;
	}
	public void act(){
		if(counter!=sideLength){
			super.act();
			counter++;
		}
		else{
			counter=1;
			turn();
			turn();
		}
	}
}