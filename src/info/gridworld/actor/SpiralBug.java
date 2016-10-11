package info.gridworld.actor;

import java.awt.Color;

public class SpiralBug extends BoxBug{
	public SpiralBug(int number){
		super(number);
	}
	public SpiralBug(int number, Color bugColor){
		super(number,bugColor);
	}
	public void act(){
		if(getCounter()!=getSideLength()){
			super.act();
		}
		else{
			setCounter(1);
			turn();
			turn();
			setSideLength(getSideLength()+1);
		}
	}
}
