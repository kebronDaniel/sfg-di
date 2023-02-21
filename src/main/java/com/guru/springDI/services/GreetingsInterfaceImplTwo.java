package com.guru.springDI.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class GreetingsInterfaceImplTwo implements GreetingsInterface {
    @Override
    public String sayGreetings() {
        return "Hello World in spanish";
    }
}
