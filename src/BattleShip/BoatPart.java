package BattleShip;

import info.gridworld.actor.Actor;

import java.awt.Color;

public class BoatPart extends Actor{
	private Color color;
	public BoatPart(Color color){
		this.color=color;
	}
	public void hit(){
		this.color=Color.RED;
	}
	public void setColor(Color color){
		this.color=color;
	}
	public Color getColor(){
		return color;
	}
}