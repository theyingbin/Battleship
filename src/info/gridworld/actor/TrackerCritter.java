package info.gridworld.actor;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class TrackerCritter extends Critter{
	Actor targetActor;
	Grid grid;
	public TrackerCritter(ActorWorld world){
		super();
		grid=world.getGrid();
		ArrayList<Location> locs=grid.getOccupiedLocations();
		for(int i=locs.size()-1;i>=0;i--){
			if(grid.get(locs.get(i))==this){
				locs.remove(i);
			}
		}
		int randomIndex=(int)(Math.random()*locs.size());
		if(grid.get(locs.get(randomIndex)) instanceof Actor){
			targetActor=(Actor)grid.get(locs.get(randomIndex));
		}
	}
	public void processActors(ArrayList<Actor> actors){
		Location target=targetActor.getLocation();
		for(Actor a:actors){
			if(a.getLocation().equals(target)){
				ArrayList<Location> locs=getGrid().getOccupiedLocations();
				for(int i=locs.size()-1;i>=0;i--){
					if(locs.get(i).equals(target) || grid.get(locs.get(i))==this){
						locs.remove(i);
					}
				}
				Color color=targetActor.getColor();
				setColor(color);
				int randomIndex=(int)(Math.random()*locs.size());
				target=locs.get(randomIndex);
				targetActor=(Actor)grid.get(target);
			}
		}
	}
	public ArrayList<Location> getMoveLocations(){
		Location target=targetActor.getLocation();
		int direction=getLocation().getDirectionToward(target);
		ArrayList<Location> locs=new ArrayList<Location>();
		locs.add(getLocation().getAdjacentLocation(direction));
		return locs;
	}
	public void makeMove(Location loc){
		System.out.println(targetActor.getLocation());
		Location current=getLocation();
		setDirection(current.getDirectionToward(loc));
		super.makeMove(loc);
	}
}