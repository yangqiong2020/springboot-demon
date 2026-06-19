package yq.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import yq.service.UsersService;

/**
 * Quartz 任务类（Spring Boot 整合版）
 * <p>
 * 与 21-quartz-demo 中的 QuartzDemo 不同，本类通过 @Autowired 注入了 Spring 管理的 UsersService，
 * 实现了在 Quartz 任务中调用 Spring Bean 的功能。
 * </p>
 * <p>
 * 注意：默认情况下 Quartz 创建 Job 实例时不经过 Spring 容器，直接使用 @Autowired 会报空指针。
 * 需要配合自定义的 AdaptableJobFactory（见 MyAdaptableJobFactory）来将 Job 实例纳入 Spring 管理。
 * </p>
 *
 * @author yangqiong
 * @see yq.config.MyAdaptableJobFactory
 */
public class QuartzDemo implements Job {

	/**
	 * 通过 @Autowired 注入用户服务
	 * <p>
	 * 依赖 MyAdaptableJobFactory 将当前 Job 对象注册到 Spring 容器后，此注入才会生效。
	 * </p>
	 */
	@Autowired
	private UsersService usersService;

	/**
	 * 任务被触发时所执行的方法
	 * <p>
	 * 每次触发时打印当前时间，并调用 UsersService 的 addUsers 方法。
	 * </p>
	 *
	 * @param arg0 任务执行上下文，包含调度器、触发器等运行时信息
	 * @throws JobExecutionException 任务执行异常
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 打印执行时间，用于观察调度效果
		System.out.println("Execute...." + new Date());
		// 调用 Spring 管理的 Service 方法
		this.usersService.addUsers();
	}

}
