package yq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springBoot整合servlet方式一
 */
@SpringBootApplication
@ServletComponentScan //在springBoot启动时会扫描@Webservice，并将该类实例化
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class,args);
    }
}
