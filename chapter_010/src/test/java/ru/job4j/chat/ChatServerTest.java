package ru.job4j.chat;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing chat server.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class ChatServerTest {
    /**
     * Line separator.
     */
    private final String ln = System.getProperty("line.separator");
    /**
     * Server answers.
     */
    private String[] answers = {
            "Hello",
            "Whats up",
            "My congratulations",
            "Hi",
            "Don't worry",
            "Be happy",
            "Done"
    };

    /**
     * Testing whent ask - "finish".
     * @throws IOException - exception.
     */
    @Test
    public void whenAskFinishThenFinishServer() throws IOException {
        Socket socket = mock(Socket.class);

        ByteArrayInputStream in = new ByteArrayInputStream("finish".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        ChatServer server = new ChatServer(socket);
        server.start();
        assertThat(out.toString(), is("Bye!"));
    }

    /**
     * Test when ask "start".
     * @throws IOException - exception.
     */
    @Test
    public void whenAskStartThenServerAnswerSomePhrase() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(this.ln).join(
                        "start",
                        "finish"
                ).getBytes()

        );
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ChatServer server = new ChatServer(socket);
        server.start();
        String[] answers = out.toString().split(System.getProperty("line.separator"));
        boolean result = Arrays.asList(this.answers).contains(answers[0]);
        assertThat(result, is(true));
    }

    /**
     * Test when server is silent.
     * @throws IOException - exception.
     */
    @Test
    public void whenAskStopThenServerIsSilent() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(this.ln).join(
                        "stop",
                        "finish"
                ).getBytes()

        );
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ChatServer server = new ChatServer(socket);
        server.start();
        String[] answers = out.toString().split(System.getProperty("line.separator"));
        boolean result = Arrays.asList(this.answers).contains(answers[0]);
        assertThat(result, is(false));
    }
}