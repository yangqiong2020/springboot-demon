package yq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot 整合 Quartz 定时任务调度案例启动类
 * <p>
 * 该模块演示了如何在 Spring Boot 项目中集成 Quartz 框架，
 * 实现定时任务的配置和管理。相比 21-quartz-demo（纯 Quartz API），
 * 本模块使用 Spring 的配置类方式管理 Quartz 组件。
 * </p>
 *
 * @author yangqiong
 */
@SpringBootApplication // 标记为 Spring Boot 应用启动类，开启自动配置和组件扫描
@EnableScheduling      // 开启 Spring 对定时任务的支持
public class App {

	/**
	 * 应用程序入口方法
	 *
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
