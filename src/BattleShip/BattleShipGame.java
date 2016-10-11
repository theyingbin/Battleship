package BattleShip;

import java.awt.Color;


import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BattleShipGame {
	private Grid<BoatPart> theGrid;
	public BattleShipGame(Grid<BoatPart> gr){
		theGrid = gr;
		initialOpponentFill();
		initialPlayerFill();
		finalFill();
	}
	public void initialOpponentFill(){
		int r=(int)(Math.random()*3);
		if(r==0){
			new Boat(2,new Location(7,11),90,theGrid);
			new Boat(4,new Location(6,10),0,theGrid);
			new Boat(3, new Location(1,16),180,theGrid);
			new Boat(3, new Location(6,14),90,theGrid);
			new Boat(5, new Location(0,10),90,theGrid);
		}else if(r==1){
			new Boat(3,new Location(1,10),90,theGrid);
			new Boat(3,new Location(7,9),90,theGrid);
			new Boat(4, new Location(2,14),180,theGrid);
			new Boat(2, new Location(8,14),90,theGrid);
			new Boat(5,new Location(1,17),180,theGrid);
		}else{
			new Boat(3,new Location(3,9),90,theGrid);
			new Boat(4,new Location(5,11),180,theGrid);
			new Boat(5,new Location(0,13),180,theGrid);
			new Boat(3, new Location(7,14),90,theGrid);
			new Boat(2,new Location(3,16),90,theGrid);
		}
	}
	public void initialPlayerFill(){
		int r=(int)(Math.random()*3);
		if(r==0){
			new Boat(5, new Location(0,0),90,theGrid);
			new Boat(3, new Location(2,2),180,theGrid);
			new Boat(3, new Location(4,7),180,theGrid);
			new Boat(2, new Location(1,6),90,theGrid);
			new Boat(4, new Location(7,0),90,theGrid);
		}
		else if(r==1){
			new Boat(5, new Location(2,2),180,theGrid);
			new Boat(3,new Location(1,4),90,theGrid);
			new Boat(4, new Location(4,4),90,theGrid);
			new Boat(2, new Location(7,5),90,theGrid);
			new Boat(3, new Location(6,8),180,theGrid);
		}
		else{
			new Boat(2,new Location(3,0),90,theGrid);
			new Boat(3, new Location(1,1),90,theGrid);
			new Boat(5, new Location(4,3),180,theGrid);
			new Boat(3, new Location(7,6),90,theGrid);
			new Boat(4, new Location(1,7),180,theGrid);
		}
	}
	public void finalFill(){
		for(int r=0;r<9;r++){
			for(int c=0;c<18;c++){
				if(theGrid.get(new Location(r,c)) == null){
					theGrid.put(new Location(r,c),new LockedBoatPart(Color.BLUE));
				}
			}
		}
	}
}