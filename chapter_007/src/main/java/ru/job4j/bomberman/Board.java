package ru.job4j.bomberman;

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
    private final ReentrantLock[][] board;
    /**
     * Count of monsters.
     */
    private final int monsters;

    /**
     * Board constructor.
     * @param size - field size.
     * @param monsters - count of monsters.
     */
    public Board(int size, int monsters) {
        this.board = new ReentrantLock[size][size];
        this.monsters = monsters;
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
//           movePersonage(0, 0, "Hero");
            this.board[0][0].lock();
        });
        Thread barrier = new Thread(() -> {
            this.board[2][0].lock();
            this.board[2][1].lock();
            this.board[2][2].lock();
        });

        barrier.start();
        hero.start();

        for (int i = 0; i < monsters; i++) {
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int finalI = i + 1;
            Thread monster = new Thread(()-> {
                String name = "Monster-" + finalI;
                movePersonage(board.length - 1, board.length - 1, name);
            });
            monster.start();
        }
        Thread.sleep(10000);
    }

    /**
     * Moving personage.
     * @param startX - start position x.
     * @param startY - start position y.
     * @param name - personage name.
     */
    public void movePersonage(int startX, int startY, String name) {
        int prevX = -1;
        int prevY = -1;

        while (true) {
            boolean locked = false;
            long waitingTime = 0;

            try {
                long startTryLock = System.currentTimeMillis();
                System.out.println(String.format("%s : I'm try go to [%s][%s]", name, startX, startY));
                while (waitingTime < 5001) {
                    if (!board[startX][startY].isLocked()) {
                        board[startX][startY].lock();
                        locked = true;
                        System.out.println(name + " visit cell[" + startX + "][" + startY + "]");

                        Thread.sleep(1000);
                        prevX = startX;
                        prevY = startY;
                        break;
                    }
                    waitingTime = System.currentTimeMillis() - startTryLock;
                }
                if (!locked) {
                    System.out.println(name + ": Cell(" + startX + ", " + startY + ") is locked!");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            } finally {
                int[] position = calculateNextPosition(startX, startY);
                startX = position[0];
                startY = position[1];

                if (prevX >= 0 && prevY >= 0 && locked) {
                    board[prevX][prevY].unlock();
                    System.out.println(name + " leave cell[" + prevX + "][" + prevY + "]");
                }
            }
        }
    }

    /**
     * Moving hero.
     * @param startX - start position x.
     * @param startY - start position y.
     * @param name - personage name.
     */
    public void moveHero(int startX, int startY, String name) {
        int prevX = -1;
        int prevY = -1;

        while (true) {
            boolean locked = false;
            long waitingTime = 0;

            try {
                long startTryLock = System.currentTimeMillis();
                System.out.println(String.format("%s : I'm try go to [%s][%s]", name, startX, startY));
                while (waitingTime < 5001) {
                    if (!board[startX][startY].isLocked()) {
                        board[startX][startY].lock();
                        locked = true;
                        System.out.println(name + " visit cell[" + startX + "][" + startY + "]");

                        Thread.sleep(1000);
                        prevX = startX;
                        prevY = startY;
                        break;
                    }
                    waitingTime = System.currentTimeMillis() - startTryLock;
                }
                if (!locked) {
                    System.out.println(name + ": Cell(" + startX + ", " + startY + ") is locked!");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            } finally {
                //todo: ask user new position.
                startX = 0;
                startY = 0;

                if (prevX >= 0 && prevY >= 0 && locked) {
                    board[prevX][prevY].unlock();
                    System.out.println(name + " leave cell[" + prevX + "][" + prevY + "]");
                }
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
