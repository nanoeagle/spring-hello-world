package com.example.springhelloworld.i18n;

import org.springframework.context.MessageSourceResolvable;

public class MarriageMessageKey implements MessageSourceResolvable {
    @Override
    public String[] getCodes() {
        return new String[] {"This not be resolved!", "marriage"};
    }
}