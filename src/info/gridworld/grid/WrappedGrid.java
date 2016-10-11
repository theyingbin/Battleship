package info.gridworld.grid;

import java.util.ArrayList;

public class WrappedGrid<E> extends BoundedGrid<E>{
	public WrappedGrid(int rows, int cols){
		super(rows,cols);
	}
	public Location convert(Location loc){
		int gridRows=getNumRows();
		int gridCols=getNumCols();
		int rows;
		int cols;
		if(loc.getRow()>=0){
			rows=loc.getRow()%gridRows;
		}
		else{
			Location location=new Location(loc.getRow()+gridRows,loc.getCol());
			convert(location);
			rows=location.getRow();
		}
		if(loc.getCol()>=0){
			cols=loc.getCol()%gridCols;
		}
		else{
			Location location=new Location(loc.getRow(),loc.getCol()+gridCols);
			convert(location);
			cols=location.getCol();
		}
		return new Location(rows,cols);
	}
	public E get(Location loc){
		return super.get(convert(loc));
	}
	public E put(Location loc, E obj){
		Location location=convert(loc);
		return super.put(location, obj);
	}
	public E remove(Location loc){
		return super.remove(convert(loc));
	}
	public ArrayList<Location> getValidAdjacentLocations(Location loc){
        ArrayList<Location> locs = new ArrayList<Location>();

        int d = Location.NORTH;
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++)
        {
            Location neighborLoc = convert(loc.getAdjacentLocation(d));
            if (isValid(neighborLoc))
                locs.add(neighborLoc);
            d = d + Location.HALF_RIGHT;
        }
        return locs;
    }
}
