package com.example.helloworld.basicdependencyinjection;

// import org.springframework.context.annotation.*;

// Mixed way of xml file and configuration class.
// @ImportResource(locations = "app-context-setter.xml")
// @ImportResource(locations = "app-context-annotation.xml")
// @ImportResource(locations = "app-context-constructor.xml")
// @ComponentScan(basePackages = "com.example.helloworld")
// @Configuration
public class HelloWorldConfig {
    // Below @Beans are alternatives to @ComponentScan above
    // when not annotate Java classes as beans 
    // (HelloWorldMessageProvider and StandardOutMessageRenderer).
    /* @Bean({"thisIsID", "alias1"})
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    } */
}