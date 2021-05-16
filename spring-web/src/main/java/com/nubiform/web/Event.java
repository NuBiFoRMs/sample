package com.nubiform.web;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event {
    private Integer id;

    private String title;

    public Event(Integer id) {
        this.id = id;
    }
}
