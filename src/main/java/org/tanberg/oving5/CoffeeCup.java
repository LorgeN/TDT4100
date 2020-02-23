package org.tanberg.oving5;

import java.util.Objects;

public class CoffeeCup {

    private double capacity;
    private double currentVolume;

    public CoffeeCup() {
        this(0.0, 0.0);
    }

    public CoffeeCup(double capacity, double currentVolume) {
        if (isValidCapacity(capacity)) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Illegal capacity given.");
        }

        if (isValidVolume(currentVolume)) {
            this.currentVolume = currentVolume;
        } else {
            throw new IllegalArgumentException("Illegal volume given.");
        }
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    private boolean isValidCapacity(double capacity) {
        return capacity >= 0.0;
    }

    public void increaseCupSize(double biggerCapacity) {
        if (!isValidCapacity(biggerCapacity)) {
            return;
        }

        this.capacity += biggerCapacity;
    }

    private boolean isValidVolume(double volume) {
        return !(volume > this.capacity) && !(volume < 0.0);
    }

    private boolean canDrink(double volume) {
        return this.currentVolume >= volume;
    }

    public void drinkCoffee(double volume) {
        if (isValidVolume(volume) && canDrink(volume)) {
            this.currentVolume -= volume;
        } else {
            throw new IllegalArgumentException("You can't drink that much coffee!");
        }
    }

    public void fillCoffee(double volume) {
        if (isValidVolume(this.currentVolume + volume)) {
            this.currentVolume += volume;
        } else {
            throw new IllegalArgumentException("You just poured coffee all over the table. Good job.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoffeeCup coffeeCup = (CoffeeCup) o;
        return Double.compare(coffeeCup.capacity, capacity) == 0 &&
                Double.compare(coffeeCup.currentVolume, currentVolume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, currentVolume);
    }

    @Override
    public String toString() {
        return "CoffeeCup{" +
                "capacity=" + capacity +
                ", currentVolume=" + currentVolume +
                '}';
    }
}

