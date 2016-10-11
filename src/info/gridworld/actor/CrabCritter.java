package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class CrabCritter extends Critter{
	public ArrayList<Location> getMoveLocations(){
		int[] direction={90,-90};
		Grid grid=getGrid();
		Location current=getLocation();
		ArrayList<Location> location=new ArrayList<Location>();
		for(int a:direction){
			Location loc=current.getAdjacentLocation( getDirection( )+ a );
			if( grid.isValid( loc ) && grid.get(loc)==null){
				location.add(loc);
			}
		}
		return location;
    }
	public ArrayList<Actor> getActors()
    {
		Grid grid=getGrid();
		Location current=getLocation();
		ArrayList<Actor> actors=new ArrayList<Actor>();
		int[] direction={0,45,315};
		for(int a:direction){
			Location loc=current.getAdjacentLocation(getDirection()+a);
			if(grid.isValid(loc)){
				if(grid.get(loc) instanceof Actor){
					actors.add((Actor)grid.get(loc));
				}
			}
		}
		return actors;
    }
	public void makeMove(Location loc){
		if (loc == null)
            removeSelfFromGrid();
		if(loc.equals(getLocation())){
			int r=(int)(Math.random()*2);
			if(r==1){
				setDirection(getDirection()+90);
			}
			if(r==0){
				setDirection(getDirection()-90);
			}
		}
		else{
			super.makeMove(loc);
		}
	}
}