package com.example.springhelloworld.collectioninjection;

import java.util.*;
import java.util.function.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;

// @Service("injectCollection")
public class CollectionInjection {
    // @Autowired
    // @Qualifier("map")
    private Map<String, Object> map;
    // @Autowired
    // @Qualifier("props")
    private Properties props;
    // @Autowired
    // @Qualifier("set")
    private Set<Object> set;
    // @Autowired
    // @Qualifier("list")
    private List<Object> list;

    public void setList(List<Object> list) { this.list = list; }
    public void setSet(Set<Object> set) { this.set = set; }
    public void setMap(Map<String, Object> map) { this.map = map; }
    public void setProps(Properties props) { this.props = props; }
   
    public void displayInfo() {
        BiConsumer<Object, Object> keyValuePrinter = (key, value) -> 
            System.out.println("Key: " + key + " - Value: " + value);
        System.out.println("Map contents:\n");
        map.forEach(keyValuePrinter);
        
        System.out.println("\nProperties contents:\n");
        props.forEach(keyValuePrinter);;
        
        Consumer<Object> valuePrinter = obj -> System.out.println("Value: " + obj);
        System.out.println("\nSet contents:\n");
        set.forEach(valuePrinter); 
        
        System.out.println("\nList contents:\n");
        list.forEach(valuePrinter);
    }
}