package com.example.helloworld;

// import com.example.helloworld.provider.*;
// import com.example.helloworld.renderer.*;

import org.springframework.context.annotation.*;

// Mixed way of xml file and configuration class.
// @ImportResource(locations = "app-context-setter.xml")
// @ImportResource(locations = "app-context-annotation.xml")
// @ImportResource(locations = "app-context-constructor.xml")
// @ImportResource(locations = "app-context-value-injection.xml")
// @ImportResource(locations = "app-context-value-injection-spEL.xml")
// @ImportResource(locations = "app-context-collection-injection.xml")
// @ImportResource(locations = "app-context-collection-injection-annotation.xml")
// @ImportResource(locations = "app-context-lookup-method-injection.xml")
@ImportResource(locations = "app-context-method-replacement.xml")
@ComponentScan(basePackages = "com.example.helloworld")
@Configuration
public class HelloWorldConfiguration {
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