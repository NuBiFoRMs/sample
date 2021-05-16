package com.nubiform.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

public class EventConverter {

    @Slf4j
    public static class StringToEventConverter implements Converter<String, Event> {

        @Override
        public Event convert(String source) {
            log.info("StringToEventConverter");
            return new Event(Integer.parseInt(source));
        }
    }

    @Slf4j
    public static class EventToStringConverter implements Converter<Event, String> {

        @Override
        public String convert(Event source) {
            log.info("EventToStringConverter");
            return source.getId().toString();
        }
    }
}
