package ru.job4j.chat;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Class for creating client.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.11.2017.
 */
public class ChatClient {
    /**
     * Socket.
     */
    private final Socket socket;

    /**
     * Constructor.
     * @param socket - socket.
     */
    public ChatClient(Socket socket) {
        this.socket = socket;
    }

    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5555)) {
            new ChatClient(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main class.
     */
    public void start() {
        try {
            System.out.println("Try connecting");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String message = "";
            String answer = "";
            boolean waitAnswer = false;

            while (!("finish".equals(message))) {
                System.out.println("Enter message for server: ");
                message = reader.readLine();
                out.write(message);
                out.newLine();
                out.flush();
                waitAnswer = checkAnswer(message, waitAnswer);
                if (waitAnswer) {
                    answer = in.readLine();
                    System.out.println("ChatServer answer: " + answer);
                }
            }
            out.write("bye!");
            out.newLine();
            out.flush();
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