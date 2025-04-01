package org.example;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Scanner scanner;

    public Game(){
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println(" Морской бой начало игры ");
        while (!board.allShipsSunk()){
            System.out.println("Введите координаты для атаки (например, 1 2): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (board.attack(x, y)) {
                System.out.println(" Попал! ");
            }
            else {
                System.out.println(" Мимо ");
            }
        }
        System.out.println("Вы уничтожили все корабли, победа! ");
    }
}
