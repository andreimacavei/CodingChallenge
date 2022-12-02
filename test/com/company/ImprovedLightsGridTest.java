package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprovedLightsGridTest {
    private Grid improvedLightsGrid;
    private Grid.Coords start;
    private Grid.Coords end;

    @BeforeEach
    void setUp() {
        improvedLightsGrid = new ImprovedLightsGrid(10, 10);
        start = new Grid.Coords(0, 0);
        end = new Grid.Coords(9, 9);
    }

    @Test
    void testTurnOnLights() {
        improvedLightsGrid.turnOn(start, end);

        assertEquals(100, improvedLightsGrid.getCountOn(),
                "Turning all lights doesn't work correctly");
    }

    @Test
    void testTurnOffLights() {
        improvedLightsGrid.turnOn(start, end);

        improvedLightsGrid.turnOff(new Grid.Coords(4,4), new Grid.Coords(5,5));

        assertEquals(96, improvedLightsGrid.getCountOn(),
                "Turning off 4 middle lights doesn't work correctly");
    }

    @Test
    void testToggleLights() {
        improvedLightsGrid.turnOn(start, end);
        improvedLightsGrid.toggle(new Grid.Coords(0,0), new Grid.Coords(9,9));

        assertEquals(300, improvedLightsGrid.getCountOn(),
                "Toggle-ing all lights doesn't work correctly");
    }

    @Test
    void testExampleInput() {
        improvedLightsGrid.turnOn(start, end);
        improvedLightsGrid.turnOff(new Grid.Coords(4,4), new Grid.Coords(5,5));
        improvedLightsGrid.toggle(new Grid.Coords(0,4), new Grid.Coords(9,5));

        assertEquals(136, improvedLightsGrid.getCountOn(),
                "Commands don't work as expected");
    }

    @Test()
    void testOutOfBoundsExceptionThrown() {
        OutOfBoundsException thrown = Assertions.assertThrows(OutOfBoundsException.class, () -> {
            improvedLightsGrid.toggle(new Grid.Coords(-1, 10), new Grid.Coords(0, 20));
        }, "Out of range validation failed!");

        assertEquals("Error - bad coordinates: start=(-1, 10), end=(0, 20)", thrown.getMessage());
    }
}
