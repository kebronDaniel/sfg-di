package com.guru.springDI.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GreetingsInterfaceImpl implements GreetingsInterface {
    @Override
    public String sayGreetings() {
        return "Hello World in English";
    }
}
