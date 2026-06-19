package yq.service;

import org.springframework.stereotype.Service;

/**
 * 用户服务类
 * <p>
 * 演示在 Quartz 定时任务中调用 Spring 管理的 Service 层方法。
 * 该类被 Spring 容器管理，可以在 Quartz Job 中通过 @Autowired 注入使用。
 * </p>
 *
 * @author yangqiong
 */
@Service
public class UsersService {

	/**
	 * 添加用户方法
	 * <p>
	 * 此处为演示用途，仅打印日志。
	 * 实际项目中可在此处实现用户入库等业务逻辑。
	 * </p>
	 */
	public void addUsers() {
		System.out.println("Add Users......");
	}
}
