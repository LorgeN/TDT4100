package org.tanberg.oving3;

import java.util.Stack;

public class RPNCalc {

	private final Stack<Double> stack;

	public RPNCalc() {
		this.stack = new Stack<>();
	}

	public void push(double value) {
		this.stack.push(value);
	}

	public double pop() {
		if (this.stack.isEmpty()) {
			return Double.NaN;
		}

		return this.stack.pop();
	}

	public double peek(int i) {
		if (this.stack.size() <= i || i < 0) {
			return Double.NaN;
		}

		return this.stack.get(this.stack.size() - 1 - i);
	}

	public int getSize() {
		return this.stack.size();
	}

	public void performOperation(char operator) {
		double operand1, operand2;
		switch (operator) {
		case '-':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			operand2 = this.pop();
			if (operand2 == Double.NaN) {
				this.push(-operand1);
				return;
			}

			this.push(operand2 - operand1);
			return;
		case '+':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			operand2 = this.pop();
			if (operand2 == Double.NaN) {
				this.push(operand1);
				return;
			}

			this.push(operand2 + operand1);
			return;
		case '*':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			operand2 = this.pop();
			if (operand2 == Double.NaN) {
				this.push(operand1);
				return;
			}

			this.push(operand2 * operand1);
			return;
		case '/':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			operand2 = this.pop();
			if (operand2 == Double.NaN) {
				this.push(operand1);
				return;
			}

			this.push(operand2 / operand1);
			return;
		case '~':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			operand2 = this.pop();
			if (operand2 == Double.NaN) {
				this.push(operand1);
				return;
			}

			this.push(operand1);
			this.push(operand2);
			return;
		case 'p':
			this.push(Math.PI);
			return;
		case '|':
			operand1 = this.pop();
			if (operand1 == Double.NaN) {
				return;
			}

			this.push(Math.abs(operand1));
		}
	}
}
