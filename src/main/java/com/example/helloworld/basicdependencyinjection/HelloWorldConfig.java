package com.example.helloworld.basicdependencyinjection;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.*;
// import org.springframework.core.env.Environment;

// Mixed way of xml file and configuration class.
// @ImportResource(locations = "appContextConfigs/app-context-setter.xml")
// @ImportResource(locations = "appContextConfigs/app-context-annotation.xml")
// @ImportResource(locations = "appContextConfigs/app-context-constructor.xml")
// @ComponentScan(basePackages = "com.example.helloworld")
// @Configuration
// @Import(HelloWorldConfigSupport.class)
public class HelloWorldConfig {
    // @Autowired
    // private Environment environment;

    // // Below @Beans are alternatives to @ComponentScan above
    // // when not annotate Java classes as beans.    
    // @Bean({"thisIsID", "alias1"})
    // public MessageProvider provider() {
    //     System.out.println("create MessageProvider.");        
    //     return new ConfigurableMessageProvider(
    //         environment.getProperty("message"));
    // }

    // @Bean
    // @DependsOn(value = "thisIsID")
    // public MessageRenderer renderer() {
    //     System.out.println("create MessageRenderer.");
    //     MessageRenderer renderer = new StandardOutMessageRenderer();
    //     renderer.setMessageProvider(provider());
    //     return renderer;
    // }
}