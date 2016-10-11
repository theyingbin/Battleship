package BattleShip;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class LockedBoatPart extends BoatPart{
	public LockedBoatPart(Color color){
		super(color);
	}
	public void hit(){
		setColor(Color.WHITE);
	}	
}