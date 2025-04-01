package org.example;

import java.util.Random;

public class Board {
    private static final int SIZE = 5;
    private static final int SHIPCOUNT = 3;
    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HIT = -1;

    private final int[][] grid;
    private final Random random;

    public Board() {
        this.grid = new int[SIZE][SIZE];
        this.random = new Random();
        plaseShips();
    }

    private void  plaseShips(){
        int placedShips = 0;
        while (placedShips < SHIPCOUNT){
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (grid[x][y] == EMPTY) {
                grid[x][y] = SHIP;
                placedShips ++;
            }
        }
    }

    public boolean attack(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Некорректные координаты! Введите значения от 0 до " + (SIZE - 1));
            return false;  // Возвращаем "мимо", но не ломаем программу
        }
        if (grid[x][y] == SHIP) {
            grid[x][y] = HIT;
            return true;
        }
        return false;
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }


}

