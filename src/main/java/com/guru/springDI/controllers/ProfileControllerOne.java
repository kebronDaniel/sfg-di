package com.guru.springDI.controllers;

import com.guru.springDI.services.GreetingsInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileControllerOne {

    private GreetingsInterface greetingsInterface;

    public ProfileControllerOne(@Qualifier("local") GreetingsInterface greetingsInterface) {
        this.greetingsInterface = greetingsInterface;
    }

    public String greetings(){
        return greetingsInterface.sayGreetings();
    }
}
