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
				return Colour.RED + "*" + Colour.RESET;
			} else {
				return colourNumber(minesNextTo);
			}
		} else {
			return Colour.WHITE_BOLD + "?" + Colour.RESET;
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
	
	public String colourNumber(int minesNextTo) {
		switch(minesNextTo) {
		case 0:
			return Colour.WHITE + "" + minesNextTo + Colour.RESET;
		case 1:
			return Colour.CYAN + "" + minesNextTo + Colour.RESET;
		case 2:
			return Colour.GREEN + "" + minesNextTo + Colour.RESET;
		case 3:
			return Colour.YELLOW+ "" + minesNextTo + Colour.RESET;
		case 4:
			return Colour.PURPLE + "" + minesNextTo + Colour.RESET;
		default:
			return "" + minesNextTo;
		}
	}
}
