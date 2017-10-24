package ru.job4j.bomberman;

import org.junit.Test;

/**
 * Class for testing bomberman.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 23.10.2017.
 */
public class BoardTest {
    /**
     * Test of hero moving.
     * @throws InterruptedException - exception.
     */
    @Test
    public void testBombermanMoving() throws InterruptedException {
        Board board = new Board();
        board.startGame();
    }
}
