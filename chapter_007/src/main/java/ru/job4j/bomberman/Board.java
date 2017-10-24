package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class for creating field.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 23.10.2017.
 */
public class Board {
    /**
     * Game board.
     */
    private final ReentrantLock[][] board = new ReentrantLock[5][5];

    /**
     * Board constructor.
     */
    public Board() {
        fillBoard();
    }

    /**
     * Fill board by cell.
     */
    public void fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Start bomberman.
     * @throws InterruptedException - exception.
     */
    public void startGame() throws InterruptedException {
        Thread hero = new Thread(() -> {
            moveHero();
        });
        Thread barrier = new Thread(() -> {
            this.board[2][0].lock();
            this.board[2][1].lock();
            this.board[2][2].lock();
        });

        barrier.start();
        hero.start();
        hero.join();
    }

    /**
     * Moving of hero.
     */
    public void moveHero() {
        int currentX = 0;
        int currentY = 0;
        int newX = 0;
        int newY = 0;

        while (true) {
            try {
                if (board[newX][newY].tryLock(500, TimeUnit.MILLISECONDS)) {

                    currentX = newX;
                    currentY = newY;
                    board[currentX][currentY].lock();
                    Thread.sleep(1000);
                    System.out.println("Hero visit cell[" + newX + "][" + newY + "]");

                } else {
                    System.out.println("Cell(" + newX + ", " + newY + ") is locked!");
                }
            } catch (InterruptedException e) {
                System.out.println("Cell(" + newX + ", " + newY + ") is locked!");
                continue;
            } finally {
                board[currentX][currentY].unlock();
                int[] position = calculateNextPosition(currentX, currentY);
                newX = position[0];
                newY = position[1];
            }
        }
    }

    /**
     * Calculate new position from hero.
     * @param currX - current x position.
     * @param currY - current y position.
     * @return int[].
     */
    public int[] calculateNextPosition(int currX, int currY) {
        int[] result = {currX, currY};
        while (true) {
            int rand = (int) (Math.random() * 100);

            if (rand < 25 && currX != board.length - 1) {
                result[0] = currX + 1;
            }
            if (rand >= 25 && rand < 55 && currY != board.length - 1) {
                result[1] = currY + 1;
            }
            if (rand >= 55 && rand < 75 && currX != 0) {
                result[0] = currX - 1;
            }
            if (rand > 75 && currY != 0) {
                result[1] = currY - 1;
            }
            if (currX != result[0] || currY != result[1]) {
                break;
            }
        }
        return result;
    }

}
