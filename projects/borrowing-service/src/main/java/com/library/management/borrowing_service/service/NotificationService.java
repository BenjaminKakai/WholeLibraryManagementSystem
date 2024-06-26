package com.library.management.borrowing_service.service;

import com.library.management.borrowing_service.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageProducer messageProducer;

    @Autowired
    public NotificationService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendDueDateNotification(String message) {
        messageProducer.sendMessage("due-date-notifications", message);
    }

    public void sendOverdueNotification(String message) {
        messageProducer.sendMessage("overdue-notifications", message);
    }
}
