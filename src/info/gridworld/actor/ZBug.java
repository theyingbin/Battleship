package info.gridworld.actor;

import java.awt.Color;

public class ZBug extends Bug{
	private int maxSteps;
	private boolean firstTurn;
	private boolean secondTurn;
	private int counter;
	public ZBug(int number){
		super();
		counter=1;
		maxSteps=number;
		setDirection(90);
		firstTurn=false;
		secondTurn=false;
	}
	public ZBug(int number, Color bugColor){
		super(bugColor);
		counter=1;
		maxSteps=number;
		setDirection(90);
		firstTurn=false;
		secondTurn=false;
	}
	public void act(){
		if(counter==maxSteps){
			if(firstTurn&&secondTurn){
				return;
			}else if(firstTurn&&!secondTurn){
				setDirection(90);
				secondTurn=true;
				counter=1;
			}else if(!firstTurn&&!secondTurn){
				setDirection(225);
				firstTurn=true;
				counter=1;
			}
		}else{
			if(canMove()){
				move();
				counter++;
			}
		}
	}
	
}
