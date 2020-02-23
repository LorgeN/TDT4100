package org.tanberg.oving1;

public class Rectangle implements Cloneable {

	private boolean empty;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	public Rectangle() {
		this(0, 0, 0, 0, true);
	}

	public Rectangle(int minX, int minY, int maxX, int maxY, boolean empty) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.empty = empty;
	}

	public boolean isEmpty() {
		return this.empty;
	}

	public int getMinX() {
		return this.isEmpty() ? 0 : minX;
	}

	public int getMinY() {
		return this.isEmpty() ? 0 : minY;
	}

	public int getMaxX() {
		return this.isEmpty() ? 0 : maxX;
	}

	public int getMaxY() {
		return this.isEmpty() ? 0 : maxY;
	}

	public int getWidth() {
		return this.isEmpty() ? 0 : (this.getMaxX() - this.getMinX() + 1);
	}

	public int getHeight() {
		return this.isEmpty() ? 0 : (this.getMaxY() - this.getMinY() + 1);
	}

	public boolean contains(int x, int y) {
		return !this.isEmpty() && x >= this.getMinX() && y >= this.getMinY() && x <= this.getMaxX()
				&& y <= this.getMaxY();
	}

	public boolean contains(Rectangle other) {
		return !other.isEmpty() && this.contains(other.getMinX(), other.getMinY())
				&& this.contains(other.getMaxX(), other.getMaxY());
	}

	public boolean add(int x, int y) {
		if (this.contains(x, y)) {
			return false;
		}

		this.minX = this.isEmpty() ? x : Math.min(x, this.minX);
		this.minY = this.isEmpty() ? y : Math.min(y, this.minY);
		this.maxX = this.isEmpty() ? x : Math.max(x, this.maxX);
		this.maxY = this.isEmpty() ? y : Math.max(y, this.maxY);

		this.empty = false;
		return true;
	}

	public boolean add(Rectangle other) {
		if (other.isEmpty() || this.contains(other)) {
			return false;
		}

		this.minX = this.isEmpty() ? other.getMinX() : Math.min(this.getMinX(), other.getMinX());
		this.minY = this.isEmpty() ? other.getMinY() : Math.min(this.getMinY(), other.getMinY());
		this.maxX = this.isEmpty() ? other.getMaxX() : Math.max(this.getMaxX(), other.getMaxX());
		this.maxY = this.isEmpty() ? other.getMaxY() : Math.max(this.getMaxY(), other.getMaxY());

		this.empty = false;
		return true;
	}

	public Rectangle union(Rectangle other) {
		if (this.isEmpty()) {
			return other.clone();
		}

		if (other.isEmpty()) {
			return this.clone();
		}

		int minX = Math.min(other.getMinX(), this.getMinX());
		int minY = Math.min(other.getMinY(), this.getMinY());
		int maxX = Math.max(other.getMaxX(), this.getMaxX());
		int maxY = Math.max(other.getMaxY(), this.getMaxY());
		return new Rectangle(minX, minY, maxX, maxY, false);
	}

	@Override
	public Rectangle clone() {
		return new Rectangle(this.minX, this.minY, this.maxX, this.maxY, this.empty);
	}

	@Override
	public String toString() {
		return "Rectangle [empty=" + empty + ", minX=" + minX + ", minY=" + minY + ", maxX=" + maxX + ", maxY=" + maxY
				+ "]";
	}
}
