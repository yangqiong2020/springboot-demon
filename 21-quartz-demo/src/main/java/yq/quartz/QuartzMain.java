package yq.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Quartz 原生 API 入门示例（不依赖 Spring）
 * <p>
 * 该类演示了 Quartz 调度框架的三个核心组件：
 * 1. JobDetail —— 定义"做什么事"（任务详情）
 * 2. Trigger   —— 定义"什么时间做"（触发器，控制执行时机）
 * 3. Scheduler —— 定义"在什么时间做什么事"（调度器，将任务和触发器绑定并启动）
 * </p>
 *
 * @author yangqiong
 */
public class QuartzMain {

	/**
	 * 程序入口方法
	 * <p>
	 * 通过 Quartz 原生 API 完成任务的调度配置和启动。
	 * </p>
	 *
	 * @param args 命令行参数
	 * @throws Exception 可能抛出调度器相关异常
	 */
	public static void main(String[] args) throws Exception {

		// ==================== 第一步：创建 JobDetail（任务详情） ====================
		// JobDetail 描述了任务的具体信息，包括任务类、任务名称等
		// 通过 JobBuilder 的工厂方法构建，关联我们自定义的 QuartzDemo 任务类
		JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

		/**
		 * ==================== 第二步：创建 Trigger（触发器） ====================
		 * Quartz 提供两种触发器：
		 * 1. SimpleTrigger —— 通过 SimpleScheduleBuilder 实现简单的重复调用
		 *    例如：每隔几秒执行一次（repeatSecondlyForever）
		 * 2. CronTrigger   —— 通过 CronScheduleBuilder 使用 Cron 表达式精确控制触发时间
		 *    例如："0/2 * * * * ?" 表示每 2 秒执行一次
		 *
		 * 这里注释掉的是 SimpleTrigger 方式，当前使用的是 CronTrigger 方式
		 */

		// 方式一：简单的 Trigger（已注释）
		// 每秒无限重复执行
		/*Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
				.build();*/

		// 方式二：使用 Cron 表达式的 Trigger
		// "0/2 * * * * ?" 含义：每 2 秒触发一次
		// Cron 表达式格式：秒 分 时 日 月 周 年（年可选）
		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.build();

		// ==================== 第三步：创建 Scheduler（调度器）并启动 ====================
		// Scheduler 负责将 JobDetail 和 Trigger 绑定在一起，并按计划执行任务
		// StdSchedulerFactory 从 quartz.properties 配置中获取默认调度器实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		// 将任务和触发器注册到调度器中
		scheduler.scheduleJob(job, trigger);

		// 启动调度器，任务将按照 Trigger 设定的时间开始执行
		scheduler.start();
	}

}
