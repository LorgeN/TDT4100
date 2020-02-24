package org.tanberg.oving5;

import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

public class CoffeeCupTest {

    @Test
    public void testCapacity() {
        assertThrows("Expected IllegalArgumentException when passing illegal argument -1 capacity in constructor",
                IllegalArgumentException.class, () -> new CoffeeCup(-1.0, 0.0));

        CoffeeCup cup = new CoffeeCup(1.0, 0.0);

        // Make sure constructor initializes capacity correctly
        assertWithMessage("Capacity").that(cup.getCapacity()).isEqualTo(1.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows("Expected coffee overflow", IllegalArgumentException.class, () -> cup.fillCoffee(10.0d));
        assertThrows("Expected coffee underflow", IllegalArgumentException.class, () -> cup.drinkCoffee(10.0d));
        assertWithMessage("Capacity").that(cup.getCapacity()).isEqualTo(1.0);

        // Make sure negative cup sizes are ignored
        cup.increaseCupSize(-15.0d);
        assertWithMessage("Capacity").that(cup.getCapacity()).isEqualTo(1.0);

        // Make sure increasing with valid capacity works
        cup.increaseCupSize(15.0d);
        assertWithMessage("Capacity").that(cup.getCapacity()).isEqualTo(16.0);
    }

    @Test
    public void testVolume() {
        assertThrows("Expected IllegalArgumentException when passing illegal argument -1 capacity in constructor",
                IllegalArgumentException.class, () -> new CoffeeCup(0.0, -1.0));

        CoffeeCup cup = new CoffeeCup(40.0, 0.0);

        // Make sure constructor initializes volume correctly
        assertWithMessage("Volume").that(cup.getCurrentVolume()).isEqualTo(0.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows("Expected not to be able to fill -10", IllegalArgumentException.class, () -> cup.fillCoffee(-10.0d));
        assertWithMessage("Volume").that(cup.getCurrentVolume()).isEqualTo(0.0);

        // Make sure valid arguments are handled correctly
        cup.fillCoffee(20.0d);
        assertWithMessage("Volume").that(cup.getCurrentVolume()).isEqualTo(20.0);
        cup.drinkCoffee(10.0d);
        assertWithMessage("Volume").that(cup.getCurrentVolume()).isEqualTo(10.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows("Expected not to be able to drink more coffee than available",
                IllegalArgumentException.class, () -> cup.drinkCoffee(15.0d));
        assertThrows("Expected coffee overflow",
                IllegalArgumentException.class, () -> cup.fillCoffee(50.0d));
        assertWithMessage("Volume").that(cup.getCurrentVolume()).isEqualTo(10.0);
    }
}
