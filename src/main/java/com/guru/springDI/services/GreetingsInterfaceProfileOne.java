package com.guru.springDI.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"am","default"})
@Service("local")
public class GreetingsInterfaceProfileOne implements GreetingsInterface {
    @Override
    public String sayGreetings() {
        return "Hello in Amharic";
    }
}
