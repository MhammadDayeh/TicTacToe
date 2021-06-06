package tictactoe;

import javax.swing.JButton;

class Button extends JButton {
	private static final long serialVersionUID = 1L;
	private String mark;
	private boolean isX = false, isO = false;
	
	Button(String mark) {
		setMark(mark);
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setIsX(boolean isX) {
		this.isX = isX;
	}

	public void setIsO(boolean isO) {
		this.isO = isO;
	}
	
	public boolean isTaken() {
		if (isX || isO) return true;
		return false;
	}

	public boolean getIsO() {
		return this.isO;
	}
	
	public boolean getIsX() {
		return this.isX;
	}

	public String getMark() {
		return this.mark;
	}
}
