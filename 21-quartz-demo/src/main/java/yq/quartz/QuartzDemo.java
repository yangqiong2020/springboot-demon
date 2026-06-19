package yq.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定义任务类
 * <p>
 * 实现 Quartz 的 Job 接口，定义具体要执行的任务逻辑。
 * 每当触发器（Trigger）到时间时，Quartz 就会调用 execute 方法来执行任务。
 * </p>
 *
 * @author yangqiong
 */
public class QuartzDemo implements Job {

	/**
	 * 任务被触发时所执行的方法
	 * <p>
	 * Quartz 调度器会在每次触发时间到达时调用此方法。
	 * JobExecutionContext 参数包含了任务的运行时上下文信息，
	 * 例如触发器详情、调度器信息、任务数据等。
	 * </p>
	 *
	 * @param arg0 任务执行上下文，提供运行时环境信息
	 * @throws JobExecutionException 任务执行过程中可能出现异常
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// 打印任务执行时间，用于观察调度效果
		System.out.println("Execute...." + new Date());
	}

}
