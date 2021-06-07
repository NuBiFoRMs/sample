package com.nubiform.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Slf4j
@Service
@Validated
public class EventService {

    public void getEvent(@Valid @EventId String id) {
        log.info("id: {}", id);
    }
}
