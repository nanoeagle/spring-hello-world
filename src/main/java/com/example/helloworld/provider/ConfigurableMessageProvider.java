package com.example.helloworld.provider;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired // does not need if there is only one constructor.
    public ConfigurableMessageProvider(
        @Value("Oh yeah meo meo.") // alternatives to bean message in ...annotation.xml
        String message
    ) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}