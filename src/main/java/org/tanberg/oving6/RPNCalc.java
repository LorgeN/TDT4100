package org.tanberg.oving6;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class RPNCalc {

    private final Stack<Double> stack;
    private final Map<Character, OperatorWrapper> operators;

    public RPNCalc() {
        this.stack = new Stack<>();
        this.operators = Maps.newConcurrentMap();
    }

    public boolean addOperator(char key, BinaryOperator<Double> operator) {
		OperatorWrapper wrapper = this.operators.get(key);
		if (wrapper == null) {
        	this.operators.put(key, new OperatorWrapper(operator));
        	return true;
		}

		return wrapper.setBinary(operator);
    }

	public boolean addOperator(char key, UnaryOperator<Double> operator) {
		OperatorWrapper wrapper = this.operators.get(key);
		if (wrapper == null) {
			this.operators.put(key, new OperatorWrapper(operator));
			return true;
		}

		return wrapper.setUnary(operator);
	}

	public boolean addOperator(char key, Supplier<Double> operator) {
		OperatorWrapper wrapper = this.operators.get(key);
		if (wrapper != null) {
			return false;
		}

		this.operators.put(key, new OperatorWrapper(operator));
		return true;
	}

	public void removeOperator(char key) {
        this.operators.remove(key);
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
        OperatorWrapper wrapper = this.operators.get(operator);
        if (wrapper == null) {
            throw new UnsupportedOperationException(operator + " - Unknown operator!");
        }

        wrapper.accept(this);
    }

    public static class OperatorWrapper implements Consumer<RPNCalc> {

        private UnaryOperator<Double> unary;
        private BinaryOperator<Double> binary;
        private Supplier<Double> supplier;

        public OperatorWrapper(UnaryOperator<Double> unary) {
            this.unary = unary;
        }

        public OperatorWrapper(BinaryOperator<Double> binary) {
            this.binary = binary;
        }

        public OperatorWrapper(Supplier<Double> supplier) {
            this.supplier = supplier;
        }

        public UnaryOperator<Double> getUnary() {
            return unary;
        }

        public boolean setUnary(UnaryOperator<Double> unary) {
            if (this.unary != null || this.supplier != null) {
                return false;
            }

            this.unary = unary;
            return true;
        }

        public BinaryOperator<Double> getBinary() {
            return binary;
        }

        public boolean setBinary(BinaryOperator<Double> binary) {
            if (this.binary != null || this.supplier != null) {
                return false;
            }

            this.binary = binary;
            return true;
        }

        public Supplier<Double> getSupplier() {
            return supplier;
        }

        @Override
        public void accept(RPNCalc calc) {
        	if (this.getSupplier() != null) {
        		calc.push(this.getSupplier().get());
        		return;
			}

            double operand1 = calc.pop();
            if (Double.isNaN(operand1)) {
                return;
            }

            double operand2 = calc.pop();
            if (Double.isNaN(operand2) || this.getBinary() == null) {
            	if (this.getUnary() == null) {
            		return;
				}

            	calc.push(this.getUnary().apply(operand1));
                return;
            }

            calc.push(this.getBinary().apply(operand2, operand1));
        }
    }
}
