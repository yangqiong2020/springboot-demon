package yq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import yq.quartz.QuartzDemo;

/**
 * Quartz 配置类
 * <p>
 * 使用 Spring 的 @Configuration + @Bean 方式配置 Quartz 的三大核心组件：
 * 1. JobDetail  —— 任务详情（定义"做什么"）
 * 2. Trigger    —— 触发器（定义"什么时候做"）
 * 3. Scheduler  —— 调度器（将任务和触发器组合在一起并启动）
 * </p>
 * <p>
 * 相比 21-quartz-demo 中使用原生 API 的方式，Spring 配置类方式更优雅，
 * 便于管理，且能与其他 Spring 组件无缝集成。
 * </p>
 *
 * @author yangqiong
 */
@Configuration
public class QuartzConfig {

	/**
	 * 第一步：创建 JobDetail（任务详情）
	 * <p>
	 * 通过 JobDetailFactoryBean 创建 JobDetail 实例，
	 * 关联自定义的 QuartzDemo 任务类。
	 * </p>
	 *
	 * @return JobDetail 工厂 Bean
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		// 关联我们自定义的 Job 类
		factory.setJobClass(QuartzDemo.class);
		return factory;
	}

	/**
	 * 第二步（可选）：创建 SimpleTrigger（简单触发器）
	 * <p>
	 * 简单触发器适用于固定间隔重复执行的场景。
	 * 当前已注释，使用下方的 CronTrigger 替代。
	 * </p>
	 *
	 * <p>参数说明：</p>
	 * <ul>
	 *   <li>setRepeatInterval —— 重复间隔（毫秒），此处为 2000ms = 2秒</li>
	 *   <li>setRepeatCount    —— 重复次数，此处为 5 次</li>
	 * </ul>
	 */
	/*@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		// 关联 JobDetail 对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		// 执行间隔（毫秒）
		factory.setRepeatInterval(2000);
		// 重复次数
		factory.setRepeatCount(5);
		return factory;
	}*/

	/**
	 * 第二步：创建 CronTrigger（Cron 表达式触发器）
	 * <p>
	 * 使用 Cron 表达式精确控制触发时间，比 SimpleTrigger 更灵活。
	 * Cron 表达式 "0/2 * * * * ?" 表示每 2 秒触发一次。
	 * </p>
	 * <p>
	 * Cron 表达式格式：秒 分 时 日 月 周
	 * <ul>
	 *   <li>0/2 —— 从第 0 秒开始，每隔 2 秒</li>
	 *   <li>*   —— 每分钟</li>
	 *   <li>*   —— 每小时</li>
	 *   <li>*   —— 每天</li>
	 *   <li>*   —— 每月</li>
	 *   <li>?   —— 不限周几（与日互斥）</li>
	 * </ul>
	 * </p>
	 *
	 * @param jobDetailFactoryBean 任务详情工厂 Bean（由 Spring 自动注入）
	 * @return Cron 触发器工厂 Bean
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		// 关联 JobDetail 对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		// 设置 Cron 表达式触发时间：每 2 秒执行一次
		factory.setCronExpression("0/2 * * * * ?");
		return factory;
	}

	/**
	 * 第三步：创建 Scheduler（调度器）
	 * <p>
	 * SchedulerFactoryBean 是 Spring 提供的调度器工厂，
	 * 将 Trigger 和 JobFactory 组合在一起，启动调度。
	 * </p>
	 * <p>
	 * 重要：必须设置 setJobFactory(myAdaptableJobFactory)，
	 * 否则 Quartz 创建的 Job 实例不会被 Spring 管理，
	 * Job 中的 @Autowired 注入会失败，抛出空指针异常。
	 * </p>
	 *
	 * @param cronTriggerFactoryBean Cron 触发器工厂 Bean（由 Spring 自动注入）
	 * @param myAdaptableJobFactory  自定义 JobFactory（解决 Spring Bean 注入问题）
	 * @return 调度器工厂 Bean
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,
													 MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		// 关联 Trigger，可传入多个触发器
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		// 设置自定义 JobFactory，使 Quartz Job 实例能被 Spring 管理，支持 @Autowired 注入
		factory.setJobFactory(myAdaptableJobFactory);
		return factory;
	}
}
