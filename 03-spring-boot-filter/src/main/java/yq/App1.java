package yq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 整合filter 方式一
 */
@SpringBootApplication
@ServletComponentScan
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class,args);
    }
}
