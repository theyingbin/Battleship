package info.gridworld.actor;

import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonCritter extends Critter{
	public void processActors(ArrayList<Actor> actors){
		int size=actors.size();
		if(size==0){
			return;
		}
		else{
			int random=(int)(Math.random()*size);
			Actor actor=actors.get(random);
			setColor(actor.getColor());
		}
	}
	public void makeMove(Location loc){
		Location current=getLocation();
		setDirection(current.getDirectionToward(loc));
		super.makeMove(loc);
	}

}
