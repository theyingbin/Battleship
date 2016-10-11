package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChargingCritter extends Critter{
	public ArrayList<Location> getMoveLocations(){
		Grid grid=getGrid();
		Location current=getLocation();
		ArrayList<Location> location=new ArrayList<Location>();
		Location loc=current.getAdjacentLocation( getDirection( ) );
		if( grid.isValid( loc ) && grid.get(loc)==null){
			location.add(loc);
		}
		return location;
	}
	public ArrayList<Actor> getActors(){
		Grid grid=getGrid();
		Location current=getLocation();
		ArrayList<Actor> actors=new ArrayList<Actor>();
		Location loc=current.getAdjacentLocation( getDirection( ) );
		if(grid.isValid(loc)&&grid.get(loc) instanceof Actor){
			actors.add((Actor)grid.get(loc));
		}
		return actors;
	}
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
        	a.removeSelfFromGrid();
        	double random=Math.random();
        	if(random<0.5){
        		setDirection(getDirection()+90);
        	}else{
        		setDirection(getDirection()-90);
        	}
        }
    }
	public void makeMove(Location loc){
		if(loc==null){
			removeSelfFromGrid();
		}else if(loc.equals(getLocation())){
			double random=Math.random();
        	if(random<0.5){
        		setDirection(getDirection()+90);
        	}else{
        		setDirection(getDirection()-90);
        	}
		}else{
			super.makeMove(loc);
		}
	}
}
