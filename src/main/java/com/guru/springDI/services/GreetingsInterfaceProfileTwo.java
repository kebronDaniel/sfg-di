package com.guru.springDI.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ti")
@Service("local")
public class GreetingsInterfaceProfileTwo implements GreetingsInterface {
    @Override
    public String sayGreetings() {
        return "Hello in Tigrigna";
    }
}
