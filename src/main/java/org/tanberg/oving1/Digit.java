package org.tanberg.oving1;

public class Digit {

	public static final char[] ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

	private final int base;
	private int value;

	public Digit(int system) {
		this(system, 0);
	}

	public Digit(int system, int value) {
		this.base = system;
		this.value = value % system;
	}

	public int getBase() {
		return base;
	}

	public int getValue() {
		return value;
	}

	public boolean increment() {
		this.value++;
		if (value >= this.getBase()) {
			this.value = 0;
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(ALPHABET[this.getValue()]);
	}
}
