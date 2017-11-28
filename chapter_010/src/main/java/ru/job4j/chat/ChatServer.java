package ru.job4j.chat;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class for creating server.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.11.2017.
 */
public class ChatServer {
    /**
     * Socket.
     */
    private final Socket socket;
    /**
     * Set of answers.
     */
    private static String[] answers = {
            "Hello",
            "Whats up",
            "My congratulations",
            "Hi",
            "Don't worry",
            "Be happy",
            "Done"
    };

    /**
     * Constructor.
     * @param socket - socket.
     */
    public ChatServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {

        try (Socket socket = new ServerSocket(5555).accept()) {
            new ChatServer(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Main method.
     */
    public void start() {
        try {
            System.out.println("wait connecting");
            System.out.println("Connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String message = "";
            String answer = "";
            boolean canAnswer = false;

            while (!("finish".equals(message))) {
                message = in.readLine();
                System.out.println(message);
                canAnswer = setRecorder(message, canAnswer);
                if (canAnswer) {
                    answer = sendAnswer(out);
                    writeLog(String.format("client:%s server:%s", message, answer));
                } else {
                    writeLog(String.format("client:%s server: - ", message));
                }
            }
            out.write("Bye!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Send answer to client.
     * @param out - OutputStream.
     * @return String.
     * @throws IOException - exception.
     */
    public static String sendAnswer(BufferedWriter out) throws IOException {
        int position = (int) (Math.random() * answers.length - 1);
        out.write(answers[position]);
        out.write(System.getProperty("line.separator"));
        out.newLine();
        out.flush();

        return answers[position];
    }

    /**
     * Set flag for server answer to client.
     * @param mesg - client message.
     * @param flag - flag.
     * @return boolean.
     */
    private static boolean setRecorder(String mesg, boolean flag) {
        boolean res = flag;
        if (mesg.equals("start")) {
            res = true;
        }
        if (mesg.equals("stop")) {
            res = false;
        }
        return res;
    }

    /**
     * Write message log to file.
     * @param mesg - message.
     * @throws IOException - exception.
     */
    private static void writeLog(String mesg) throws IOException {

        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(".\\chatlog.txt"), true));

        String text = mesg;
        out.write(mesg.getBytes());
        out.write('\n');
        out.flush();
        out.close();
    }

}