package BattleShip;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Boat {
	private int size;
	private int timesHit;
	private BoatPart[] boats;
	public Boat(int size, Location start, int direction,Grid<BoatPart> grid){
		this.size=size;
		timesHit=0;
		boats=new BoatPart[size];
		for(int i=0;i<size;i++){
			boats[i]=new BoatPart(Color.BLUE);
		}
		createBoat(start,direction,grid);
	}
	public void hit(Location loc){
		for(int i=0;i<size;i++){
			if(boats[i].getLocation().equals(loc)){
				boats[i].setColor(Color.RED);
			}
		}
		timesHit++;
	}
	public int getTimesHit(){
		int hit=0;
		for(int i=0;i<size;i++){
			if(boats[i].getColor()==Color.RED){
				hit++;
			}
		}
		return hit;
	}
	public int getSize(){
		return size;
	}
	public void createBoat(Location start, int direction, Grid<BoatPart> grid){
		try{
			ArrayList<Location> locs=new ArrayList<Location>();
			locs.add(start);
			Location loc=start;
			for(int i=1;i<size;i++){
				loc=loc.getAdjacentLocation(direction);
				locs.add(loc);
			}
			for(int i=0;i<size;i++){
				if(locs.get(i).getCol()<9){
					boats[i].setColor(Color.BLACK);
				}
				grid.put(locs.get(i),boats[i]);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
		}
	}
}