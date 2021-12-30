package com.example.springhelloworld.editorsforproperties;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.*;
import org.springframework.beans.propertyeditors.*;

public class CustomPropertyEditorRegistrar 
implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");
        registry.registerCustomEditor(
            Date.class, new CustomDateEditor(dateFormater, true));
        registry.registerCustomEditor(
            String.class, new StringTrimmerEditor(true));
        // An alternative to p:customEditors-ref in the app-context-config file.
        // registry.registerCustomEditor(
        //     FullName.class, new FullNamePropertyEditor());
    }
}