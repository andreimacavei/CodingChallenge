package com.company;

public class LightsGrid extends Grid{

    public LightsGrid (int width, int height) {
        super(width, height);
    }

    public void turnOn(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            throw new OutOfBoundsException("Error - bad coordinates: start=" + start + ", end=" + end);
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                if (grid[i][j] == 0) {
                    countOn++;
                }
                grid[i][j] = 1;
            }
        }
    }

    public void turnOff(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            throw new OutOfBoundsException("Error - bad coordinates: start=" + start + ", end=" + end);
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                if (grid[i][j] == 1) {
                    countOn--;
                }
                grid[i][j] = 0;
            }
        }
    }

    public void toggle(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            throw new OutOfBoundsException("Error - bad coordinates: start=" + start + ", end=" + end);
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                if (grid[i][j] == 0) {
                    countOn++;
                    grid[i][j] = 1;
                } else {
                    countOn--;
                    grid[i][j] = 0;
                }
            }
        }
    }
}
