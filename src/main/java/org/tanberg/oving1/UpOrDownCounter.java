package org.tanberg.oving1;

public class UpOrDownCounter {

	private final int start;
	private final int end;
	private final int offset;
	private int current;

	public UpOrDownCounter(int start, int end) {
		this(start, end, start < end ? 1 : -1);
	}

	public UpOrDownCounter(int start, int end, int offset) {
		this.offset = offset;
		if (start == end) {
			throw new IllegalArgumentException("start and end can not be the same value!");
		}

		this.start = start;
		this.end = end;
		this.current = start;
	}

	public int getCounter() {
		return this.current;
	}

	public boolean count() {
		if (this.current == this.end) {
			return false;
		}

		this.current += this.offset;
		return this.current != this.end;
	}

	public void reset() {
		this.current = this.start;
	}
}
