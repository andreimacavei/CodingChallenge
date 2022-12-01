package com.company;

abstract class Grid {

    protected int width;
    protected int height;
    protected int grid[][];
    protected int countOn = 0;

    public Grid (int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
    }

    public abstract void turnOn(LightsGrid.Coords start, LightsGrid.Coords end);

    public abstract void turnOff(LightsGrid.Coords start, LightsGrid.Coords end);

    public abstract void toggle(LightsGrid.Coords start, LightsGrid.Coords end);

    public int getCountOn() {
        return countOn;
    }

    public static class Coords {
        private final int x;
        private final int y;

        public Coords (int x, int y) {

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        public static boolean validateCoords(Coords coords, int width, int heigth) {
            if (coords.x < 0 || coords.x >= width || coords.y < 0 || coords.y >= heigth) {
                return false;
            }

            return true;
        }
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
