package org.tanberg.oving5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Coffee Cup")
public class CoffeeCupTest {

    @Test
    @DisplayName("Capacity")
    public void testCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new CoffeeCup(-1.0, 0.0));

        CoffeeCup cup = new CoffeeCup(1.0, 0.0);

        // Make sure constructor initializes capacity correctly
        assertThat(cup.getCapacity()).isEqualTo(1.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows(IllegalArgumentException.class, () -> cup.fillCoffee(10.0d));
        assertThrows(IllegalArgumentException.class, () -> cup.drinkCoffee(10.0d));
        assertThat(cup.getCapacity()).isEqualTo(1.0);

        // Make sure negative cup sizes are ignored
        cup.increaseCupSize(-15.0d);
        assertThat(cup.getCapacity()).isEqualTo(1.0);

        // Make sure increasing with valid capacity works
        cup.increaseCupSize(15.0d);
        assertThat(cup.getCapacity()).isEqualTo(16.0);
    }

    @Test
    @DisplayName("Volume")
    public void testVolume() {
        assertThrows(IllegalArgumentException.class, () -> new CoffeeCup(0.0, -1.0));

        CoffeeCup cup = new CoffeeCup(40.0, 0.0);

        // Make sure constructor initializes volume correctly
        assertThat(cup.getCurrentVolume()).isEqualTo(0.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows(IllegalArgumentException.class, () -> cup.fillCoffee(-10.0d));
        assertThat(cup.getCurrentVolume()).isEqualTo(0.0);

        // Make sure valid arguments are handled correctly
        cup.fillCoffee(20.0d);
        assertThat(cup.getCurrentVolume()).isEqualTo(20.0);
        cup.drinkCoffee(10.0d);
        assertThat(cup.getCurrentVolume()).isEqualTo(10.0);

        // Make sure invalid arguments are handled and ignored
        assertThrows(IllegalArgumentException.class, () -> cup.drinkCoffee(15.0d));
        assertThrows(IllegalArgumentException.class, () -> cup.fillCoffee(50.0d));
        assertThat(cup.getCurrentVolume()).isEqualTo(10.0);
    }
}
