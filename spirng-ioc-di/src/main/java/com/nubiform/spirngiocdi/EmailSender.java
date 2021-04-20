package com.nubiform.spirngiocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailSender implements NotificationSender {
    private static final Logger log = LoggerFactory.getLogger(EmailSender.class);

    static {
        log.debug("public class EmailSender implements NotificationSender");
    }

    public EmailSender() {
        log.debug("public EmailSender()");
    }

    @Override
    public void send(String content) {
        log.debug("public void send(String content)");
        log.info("content: Email: {}", content);
    }
}
