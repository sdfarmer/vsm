package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//war
public class VsmApplication extends SpringBootServletInitializer {
//public class VsmApplication extends SpringBootServletInitializer {
//jar
//    public static void main(String[] args) {
//        SpringApplication.run(VsmApplication.class, args);
//    }


//war

    public static void main(String[] args) {
        SpringApplication.run(VsmApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VsmApplication.class);
    }



}
