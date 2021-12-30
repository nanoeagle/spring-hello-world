package com.example.springhelloworld.resourceaccess;

import java.io.*;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceAccessDemo {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();

        Resource fileRes = context.getResource(
            "classpath:supportFiles/propertyEditorTest.txt");
        displayResourceInfo(fileRes);
        displayResourceContent(fileRes);
        
        Resource webRes = context.getResource("https://www.google.com/");
        displayResourceInfo(webRes);
        displayResourceContent(webRes);

        context.close();
    }

    private static void displayResourceInfo(Resource res) throws IOException {
        System.out.println(res.getClass());
        System.out.println(res.getURL());
        System.out.println(res.lastModified());
        System.out.println(res.contentLength());
    }

    public static void displayResourceContent(Resource res) throws IOException {
        BufferedReader resourceReader =
            new BufferedReader(new InputStreamReader(res.getInputStream()));
        resourceReader.lines().forEach(System.out::println);
        resourceReader.close();
    }
}