package com.example.springhelloworld.editorsforproperties;

public class CustomPropertyEditorBean {
    private FullName fullName;

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
        System.out.println(this.fullName);
    }
}