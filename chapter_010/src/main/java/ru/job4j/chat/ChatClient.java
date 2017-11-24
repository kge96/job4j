package ru.job4j.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class for creating client.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.11.2017.
 */
public class ChatClient {
    /**
     * Port for connection.
     */
    private static final int PORT = 5555;
    /**
     * Ip for connection.
     */
    private static final String IP = "127.0.0.1";

    /**
     * Main class.
     * @param args - args.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Try connecting to " + IP);
            Socket socket = new Socket(IP, PORT);

            InputStream socketIS = socket.getInputStream();
            OutputStream socketOS = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIS);
            DataOutputStream out = new DataOutputStream(socketOS);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            String answer = "";
            boolean waitAnswer = false;

            while (!message.equals("finish")) {
                System.out.println("Enter message for server: ");
                message = reader.readLine();
                out.writeUTF(message);
                out.flush();
                waitAnswer = checkAnswer(message, waitAnswer);
                if (waitAnswer) {
                    answer = in.readUTF();
                    System.out.println("ChatServer answer: " + answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check client answer if true then client wait answer from server
     * else continues send message to server.
     * @param mesg - message.
     * @param flag - flag for waiting answer.
     * @return boolean.
     */
    private static boolean checkAnswer(String mesg, boolean flag) {
        boolean res = flag;
        if (mesg.equals("start")) {
            res = true;
        }

        if (mesg.equals("stop")) {
            res = false;
        }
        return res;
    }
}
