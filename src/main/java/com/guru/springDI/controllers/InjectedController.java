package com.guru.springDI.controllers;


import com.guru.springDI.services.GreetingsInterface;
import com.guru.springDI.services.GreetingsInterfaceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class InjectedController {

    public GreetingsInterface greetingsInterface;

    public String showGreetings(){
        return greetingsInterface.sayGreetings();
    }
}
