package com.nubiform.web;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;

@Slf4j
public class EventPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        log.info("EventPropertyEditor getAsText");
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        log.info("EventPropertyEditor setAsText");
        setValue(new Event(Integer.parseInt(text)));
    }
}
