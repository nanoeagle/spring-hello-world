package com.example.helloworld.editorsforproperties;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class PropertyEditorBean {
    private byte[] bytes; // ByteArrayPropertyEditor
    private Character character; //CharacterEditor
    private Class<?> genericClass; // ClassEditor
    private Boolean trueOrFalse; // CustomBooleanEditor
    private List<String> stringList; // CustomCollectionEditor
    private Date date; // CustomDateEditor
    private Float floatValue; // CustomNumberEditor
    private File file; // FileEditor
    private InputStream iStream; // InputStreamEditor
    private Locale locale; // LocaleEditor
    private Pattern pattern; // PatternEditor
    private Properties properties; // PropertiesEditor
    private String trimString; // StringTrimmerEditor
    private URL url; // URLEditor

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
        System.out.println("Setting bytes: " + Arrays.toString(bytes));
    }

    public void setCharacter(Character character) {
        this.character = character;
        System.out.println("Setting character: " + character);
    }

    public void setGenericClass(Class<?> genericClass) {
        this.genericClass = genericClass;
        System.out.println("Setting class: " + genericClass.getName());
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
        System.out.println("Setting Boolean: " + trueOrFalse);
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
        System.out.println(
            "Setting string list with size: " + stringList.size());
        for (String string : stringList) {
            System.out.println("String member: " + string);
        }
    }

    public void setDate(Date date) {
        this.date = date;
        System.out.println("Setting date: " + date);
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
        System.out.println("Setting float value: " + floatValue);
    }

    public void setFile(File file) {
        this.file = file;
        System.out.println("Setting file: " + file.getName());
    }

    public void setIStream(InputStream iStream) {
        this.iStream = iStream;
        System.out.println("Setting stream: " + iStream);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        System.out.println("Setting locale: " + locale.getDisplayName());
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
        System.out.println("Setting pattern: " + pattern);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
        System.out.println("Loaded " + properties.size() + " properties");
        this.properties.forEach((k, v) -> System.out.println("\t" + k + ": " + v));
    }

    public void setTrimString(String trimString) {
        this.trimString = trimString;
        System.out.println("Setting trim string: " + trimString);
    }

    public void setUrl(URL url) {
        this.url = url;
        System.out.println("Setting URL: " + url.toExternalForm());
    }     
}