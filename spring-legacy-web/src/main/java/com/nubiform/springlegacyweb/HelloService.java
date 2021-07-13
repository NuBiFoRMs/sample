package com.nubiform.springlegacyweb;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHello() {
        return "nubiform";
    }
}
