package Minesweeper;

public class Cell {
	private boolean isSelected;
	
	public Cell() {
		this.isSelected = false;
	}
	
	public void select() {
		this.isSelected = true;
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public String toString() {
		if(isSelected) {
			return "■";
		} else {
			return "?";
		}
	}
}
