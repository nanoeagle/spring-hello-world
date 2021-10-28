package com.example.helloworld.editorsforproperties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyEditorDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(PropertyEditorConfig.class);
        context.getBean("propertyEditorBean", PropertyEditorBean.class);
        context.getBean("customPropertyEditorBean", CustomPropertyEditorBean.class);
        context.close();
    }
}