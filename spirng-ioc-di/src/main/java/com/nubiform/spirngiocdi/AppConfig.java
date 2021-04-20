package com.nubiform.spirngiocdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    static {
        log.debug("public class AppConfig");
    }

    @Bean
    @Profile({"default", "dev"})
    public NotificationSender emailNotificationSender() {
        log.debug("public NotificationSender emailNotificationSender()");
        return new EmailSender();
    }

    @Bean
    @Profile("prod")
    public NotificationSender smsNotificationSender() {
        log.debug("public NotificationSender smsNotificationSender()");
        return new SmsSender();
    }
}
