package com.nubiform.spirngiocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsSender implements NotificationSender {
    private static final Logger log = LoggerFactory.getLogger(SmsSender.class);

    static {
        log.debug("public class SmsSender implements NotificationSender");
    }

    public SmsSender() {
        log.debug("SmsSender.SmsSender");
    }

    @Override
    public void send(String content) {
        log.debug("SmsSender.send");
        log.info("content: Sms: {}", content);
    }
}
