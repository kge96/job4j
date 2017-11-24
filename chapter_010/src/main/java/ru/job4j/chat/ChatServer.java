package ru.job4j.chat;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * Class for creating server.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 24.11.2017.
 */
public class ChatServer {
    /**
     * Port number for connection to server.
     */
    private static final int PORT = 5555;
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
     * Main method.
     * @param args - args.
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("wait connecting");
            Socket socket = serverSocket.accept();
            System.out.println("Connected!");

            InputStream socketIS = socket.getInputStream();
            OutputStream socketOS = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIS);
            DataOutputStream out = new DataOutputStream(socketOS);

            String message = "";
            String answer = "";
            boolean canAnswer = false;

            while (!message.equals("finish")) {
                message = in.readUTF();
                System.out.println(message);
                canAnswer = setRecorder(message, canAnswer);
                if (canAnswer) {
                    answer = sendAnswer(out);
                    writeLog(String.format("client:%s server:%s", message, answer));
                } else {
                    writeLog(String.format("client:%s server: - ", message));
                }
            }
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
    public static String sendAnswer(DataOutputStream out) throws IOException {
        int position = (int) (Math.random() * answers.length - 1);
        System.out.println("ChatServer answer: " + answers[0]);
        out.writeUTF(answers[position]);
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
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("chapter_010\\src\\main\\java\\ru\\job4j\\chat\\chatlog\\chatog.txt"), true));
        String text = mesg;
        out.write(mesg.getBytes());
        out.write('\n');
        out.flush();
        out.close();
    }

}
