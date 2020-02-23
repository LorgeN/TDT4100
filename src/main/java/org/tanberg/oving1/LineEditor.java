package org.tanberg.oving1;

public class LineEditor {

	private StringBuffer text;
	private int insertionIndex;

	public LineEditor() {
		this.text = new StringBuffer();
		this.insertionIndex = 0;
	}

	public void left() {
		this.left(1);
	}

	public void left(int n) {
		this.insertionIndex = Math.max(0, this.insertionIndex - n);
	}

	public void right() {
		this.right(1);
	}

	public void right(int n) {
		this.insertionIndex = Math.min(this.text.length(), this.insertionIndex + n);
	}

	public void insert(Object obj) {
		this.insertString(String.valueOf(obj));
	}

	public void insertString(String str) {
		this.text.insert(this.insertionIndex, str);
		this.insertionIndex += str.length();
	}

	public void deleteLeft() {
		if (this.insertionIndex < 1) {
			return;
		}

		this.text.delete(this.insertionIndex - 1, this.insertionIndex);
		this.insertionIndex--;
	}

	public void deleteRight() {
		if (this.insertionIndex > (this.text.length() - 1)) {
			return;
		}

		this.text.delete(this.insertionIndex, this.insertionIndex + 1);
	}

	public String getText() {
		return this.text.toString();
	}

	public void setText(String str) {
		this.text = new StringBuffer(str);
		this.insertionIndex = 0;
	}

	public int getInsertionIndex() {
		return insertionIndex;
	}

	public void setInsertionIndex(int insertionIndex) {
		this.insertionIndex = insertionIndex;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(this.text);
		buffer.insert(this.insertionIndex, "|");
		return buffer.toString();
	}
}
