package com.nubiform.spirngiocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    static {
        log.debug("public class MyService");
    }

    private final NotificationSender notificationSender;

    public MyService(NotificationSender notificationSender) {
        log.debug("public MyService(NotificationSender notificationSender)");
        this.notificationSender = notificationSender;
    }

    public void sendNotification(String message) {
        log.debug("public void sendNotification(String message)");
        log.info("Biz. Logic");
        notificationSender.send(message);
    }
}
