package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Part 1
        Grid lightsGrid = new LightsGrid(1000, 1000);
        // Part 2 (uncomment for use)
//        Grid lightsGrid = new ImprovedLightsGrid(1000, 1000);

        try {
            FileInputStream fileInput = new FileInputStream("coding_challenge_input.txt");
            Scanner scanner = new Scanner(fileInput);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    executeCommand(line, lightsGrid);
                } catch (OutOfBoundsException e) {
                    System.out.println(e);
                    System.out.println("Bad coordinates: " + line + "\nSkip to next input line");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(lightsGrid.getCountOn());
    }

    public static void executeCommand(String line, Grid grid) {
        String[] splitLine = line.trim().split("\\s+");
        Grid.Coords[] coords = extractCoords(splitLine);

        if (coords.length < 2) {
            return;
        }

        processCommand(splitLine, coords, grid);
    }

    private static void processCommand(String[] splitLine, Grid.Coords[] coords, Grid grid) {
        if (splitLine[0].equals("turn")) {
            if (splitLine[1].equals("on")) {
                grid.turnOn(coords[0], coords[1]);
            } else if (splitLine[1].equals("off")) {
                grid.turnOff(coords[0], coords[1]);
            }

        } else if (splitLine[0].equals("toggle")) {
            grid.toggle(coords[0], coords[1]);
        }
    }

    private static Grid.Coords[] extractCoords(String[] commandTokens) {
        if (commandTokens.length == 0 ||
                commandTokens[0].equals("turn") && commandTokens.length < 5 ||
                commandTokens[0].equals("toggle") && commandTokens.length < 4) {

            System.out.println("Error - incorrect input line:" + String.join(" ", commandTokens));
            return null;
        }

        String[] coords = commandTokens[0].equals("turn") ? commandTokens[2].split(",") : commandTokens[1].split(",");
        Grid.Coords start = new Grid.Coords(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));

        coords = commandTokens[0].equals("turn") ? commandTokens[4].split(",") : commandTokens[3].split(",");
        Grid.Coords end = new Grid.Coords(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));

        return new Grid.Coords[]{start, end};
    }
}
