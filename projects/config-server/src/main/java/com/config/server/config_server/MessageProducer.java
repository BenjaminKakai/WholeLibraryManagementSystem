package com.config.server.config_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Source.class)
public class MessageProducer {

    private final MessageChannel outputChannel;

    @Autowired
    public MessageProducer(Source source) {
        this.outputChannel = source.output();
    }

    public void sendMessage(String message) {
        outputChannel.send(MessageBuilder.withPayload(message).build());
    }
}
