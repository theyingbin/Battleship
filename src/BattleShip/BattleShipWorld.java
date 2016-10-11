package BattleShip;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class BattleShipWorld extends World<BoatPart>{
	
	// Public Interface
	public BattleShipWorld(){
		super(new BoundedGrid<BoatPart>(9,18));
		game = new BattleShipGame(getGrid());
		hashTable = new boolean[9][18];
		endOfGame = false;
		locsToHit = new LinkedList<Location>();
	}
	public BattleShipGame getGame(){
		return game;
	}
	public boolean locationClicked(Location loc){
		if(endOfGame)
			return true;
		if(loc.getCol()<9){
			JOptionPane.showMessageDialog(null, "Friendly fire! Kill the traitor!!");
			setMessage("Friendly fire! Kill the traitor!!");
			return true;
		}
		else{
			// Player Turn
			if(getGrid().get(loc)!=null){
				BoatPart boat = getGrid().get(loc);
				int row = loc.getRow();
				int col = loc.getCol();
				if(hashTable[row][col] == true){
					JOptionPane.showMessageDialog(null, "Location already clicked");
					setMessage("Location already clicked");
					return true;
				}
				else{
					boat.hit();
					hashTable[row][col] = true;
					Location opponentHit=enemyChosesLocation();
					BoatPart toHit = getGrid().get(opponentHit);
					if(toHit != null){
						toHit.hit();
						if(toHit.getColor() == Color.RED){
							addNextLocations(opponentHit);
						}
					}
					setMessage("Guess the next location");
					winCondition(true);
					winCondition(false);
				}
			}
			return true;
		}
	}
	public void winCondition(boolean isPlayer){
		int numDestroyed = numShipsDestroyed(isPlayer);
		if(numDestroyed == 17 && !isPlayer){
			JOptionPane.showMessageDialog(null, "The enemy has destroyed all your ships. Abort Mission!!");
			setMessage("The enemy has destroyed all your ships. Abort Mission!!");
			endOfGame = true;
		}
		else if(numDestroyed == 17 && isPlayer){
			JOptionPane.showMessageDialog(null, "Mission Success!");
			setMessage("Mission Success!");
			endOfGame = true;
		}
	}
	
	// Private variables and functions
	private Queue<Location> locsToHit;
	private boolean[][] hashTable;
	private BattleShipGame game;
	private boolean endOfGame;
	private int numShipsDestroyed(boolean isPlayer){
		int numDestroyed = 0;
		for(int r = 0; r < 9; r++){
			int c = 0;
			if(isPlayer){
				c += 9;
			}
			int lastCol = c + 9;
			for(;c < lastCol; c++){
				if(getGrid().get(new Location(r,c)).getColor().equals(Color.RED)){
					numDestroyed++;
				}
			}
		}
		return numDestroyed;
	}
	private Location enemyChosesLocation(){
		if(!locsToHit.isEmpty()){
			Location smartLoc = locsToHit.remove();
			hashTable[smartLoc.getRow()][smartLoc.getCol()] = true;
			return smartLoc;
		}
		int r = 0;
		int c = 0;
		while(hashTable[r][c] == true){
			r=(int)(Math.random()*9);
			c=(int)(Math.random()*9);
		}
		hashTable[r][c] = true;
		Location loc=new Location(r,c);
		return loc;
	}
	private void addNextLocations(Location loc){
		int locRow = loc.getRow();
		int locCol = loc.getCol();
		// Checks location above it
		if(locRow - 1 >= 0 && !hashTable[locRow - 1][locCol]){
			locsToHit.add(new Location(locRow - 1, locCol));
		}
		// Checks location to the left
		if(locCol + 1 < 9 && !hashTable[locRow][locCol + 1]){
			locsToHit.add(new Location(locRow, locCol + 1));
		}
		// Checks location below it
		if(locRow + 1 < 9 && !hashTable[locRow + 1][locCol]){
			locsToHit.add(new Location(locRow + 1, locCol));
		}
		// Checks location to the right
		if(locCol - 1 >= 0 && !hashTable[locRow][locCol - 1]){
			locsToHit.add(new Location(locRow, locCol - 1));
		}
	}
}