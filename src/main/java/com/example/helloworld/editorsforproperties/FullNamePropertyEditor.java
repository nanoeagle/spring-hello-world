package com.example.helloworld.editorsforproperties;

import java.beans.PropertyEditorSupport;

public class FullNamePropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] nameTokens = text.split(" ");
        setValue(new FullName(nameTokens[0], nameTokens[1]));
    }
}