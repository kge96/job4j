package ru.job4j.chat;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class for testing client.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class ChatClientTest {
    /**
     * Line separator.
     */
    private final String ln = System.getProperty("line.separator");

    /**
     * Client test.
     * @throws IOException - exception.
     */
    @Test
    public void clientTest() throws IOException {
            Socket socket = mock(Socket.class);

        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(this.ln).join(
                        "message",
                        "finish"
                ).getBytes()

        );
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            when(socket.getInputStream()).thenReturn(in);
            when(socket.getOutputStream()).thenReturn(out);
            when(System.in).thenReturn(in);


            ChatClient client = new ChatClient(socket);
            client.start();

            assertThat(out.toString(), is("message"));
    }

}