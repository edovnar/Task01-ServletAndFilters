package ioc.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ioc")
public class AppContext {

    private static ApplicationContext context = new AnnotationConfigApplicationContext("ioc");

    public static ApplicationContext getContext() {
        return context;
    }
}
