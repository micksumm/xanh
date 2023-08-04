package com.xanh;

import com.xanh.ioc.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        DatabaseConfiguration.class,
})
public class XanhApplication {
    public static void main(String[] args) {
        SpringApplication.run(XanhApplication.class, args);
    }
}
