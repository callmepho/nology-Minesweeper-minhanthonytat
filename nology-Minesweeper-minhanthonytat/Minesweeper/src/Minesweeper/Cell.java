package Minesweeper;

public class Cell {
	private boolean isSelected;
	private boolean isMine;
	private int minesNextTo;
	
	public Cell() {
		this.isSelected = false;
	}
	
	public void selected() {
		this.isSelected = true;
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public boolean getIsMine() {
		return isMine;
	}

	public void setAsMine() {
		this.isMine = true;
	}

	public int getMinesNextTo() {
		return minesNextTo;
	}

	public void setMinesNextTo(int minesNextTo) {
		this.minesNextTo = minesNextTo;
	}

	public String toString() {
		if(isSelected) {
			if(isMine) {
				return "*";
			} else {
				return ""+minesNextTo;
			}
		} else {
			return "?";
		}
	}
	
	public void resetCell() {
		this.isSelected = false;
        this.isMine = false;
        this.minesNextTo = 0;
    }
	
	public void addMinesNextTo() {
		this.minesNextTo++;
	}
}
