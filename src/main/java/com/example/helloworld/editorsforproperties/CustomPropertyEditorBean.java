package com.example.helloworld.editorsforproperties;

public class CustomPropertyEditorBean {
    private FullName fullName;

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
        System.out.println(this.fullName);
    }
}