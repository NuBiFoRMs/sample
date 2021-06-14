package com.nubiform.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.registerCustomEditor(Event.class, new EventPropertyEditor());
//    }

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        log.info("event: {}", event);
        return event.getId().toString();

    }

    @GetMapping("/id/{id}")
    public String getId(@PathVariable String id) {
        log.info("id: {}", id);
        eventService.getEvent(id);
        return id;

    }
}
