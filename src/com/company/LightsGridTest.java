package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LightsGridTest {
    private Grid lightsGrid;
    private Grid.Coords start;
    private Grid.Coords end;

    @BeforeEach
    void setUp() {
        lightsGrid = new LightsGrid(10, 10);
        start = new Grid.Coords(0, 0);
        end = new Grid.Coords(9, 9);
    }

    @Test
    void testTurnOnLights() {
        lightsGrid.turnOn(start, end);

        assertEquals(100, lightsGrid.getCountOn(),
                "Turning all lights doesn't work correctly");
    }

    @Test
    void testTurnOffLights() {
        lightsGrid.turnOn(start, end);

        lightsGrid.turnOff(new Grid.Coords(4,4), new Grid.Coords(5,5));

        assertEquals(96, lightsGrid.getCountOn(),
                "Turning off 4 middle lights doesn't work correctly");
    }

    @Test
    void testToggleOffLights() {
        lightsGrid.turnOn(start, end);
        lightsGrid.toggle(new Grid.Coords(0,0), new Grid.Coords(9,9));

        assertEquals(0, lightsGrid.getCountOn(),
                "Toggle-ing all lights off doesn't work correctly");
    }

    @Test
    void testExampleInput() {
        lightsGrid.turnOn(start, end);
        lightsGrid.turnOff(new Grid.Coords(4,4), new Grid.Coords(5,5));
        lightsGrid.toggle(new Grid.Coords(0,4), new Grid.Coords(9,5));

        assertEquals(84, lightsGrid.getCountOn(),
                    "Commands don't work as expected");
    }

    @Test()
    void testOutOfBoundsExceptionThrown() {
        OutOfBoundsException thrown = Assertions.assertThrows(OutOfBoundsException.class, () -> {
            lightsGrid.turnOn(new Grid.Coords(-1, 10), new Grid.Coords(0, 20));
        }, "Out of range validation failed!");

        assertEquals("Error - bad coordinates: start=(-1, 10), end=(0, 20)", thrown.getMessage());
    }
}
