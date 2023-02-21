package com.guru.springDI.controllers;


import com.guru.springDI.services.GreetingsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {


    private GreetingsInterface greetingsInterface;

public SampleController(GreetingsInterface greetingsInterface) {
        this.greetingsInterface = greetingsInterface;
    }

    public String showGreetings(){
        return greetingsInterface.sayGreetings();
    }
}
