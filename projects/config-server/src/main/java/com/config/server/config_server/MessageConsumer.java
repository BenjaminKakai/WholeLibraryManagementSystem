package com.config.server.config_server;


import org.apache.tomcat.util.net.WriteBuffer;

@EnableBinding(WriteBuffer.Sink.class)
public class MessageConsumer {

    @StreamListener(Sink.INPUT)
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
        // Process the received message accordingly
    }
}
