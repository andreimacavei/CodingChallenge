package com.company;

public class ImprovedLightsGrid extends Grid {

    public ImprovedLightsGrid(int width, int height) {
        super(width, height);
    }

    @Override
    public void turnOn(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            System.out.println("Error - bad coordinates: start=" + start + ", end=" + end);
            return;
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                grid[i][j]++;
                countOn++;
            }
        }
    }

    @Override
    public void turnOff(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            System.out.println("Error - bad coordinates: start=" + start + ", end=" + end);
            return;
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                if (grid[i][j] > 0) {
                    grid[i][j]--;
                    countOn--;
                }
            }
        }
    }

    @Override
    public void toggle(Coords start, Coords end) {
        if (!Coords.validateCoords(start, width, height) || !Coords.validateCoords(end, width, height)) {
            System.out.println("Error - bad coordinates: start=" + start + ", end=" + end);
            return;
        }

        for (int i=start.getX(); i <= end.getX(); i++) {
            for (int j=start.getY(); j <= end.getY(); j++) {
                grid[i][j] += 2;
                countOn += 2;
            }
        }
    }
}
