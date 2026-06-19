package yq.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义 JobFactory，解决 Quartz Job 中无法注入 Spring Bean 的问题
 * <p>
 * 默认情况下，Quartz 通过自身的机制实例化 Job 对象，不经过 Spring 容器，
 * 因此 Job 类中使用的 @Autowired 注解无法生效（注入对象为 null）。
 * </p>
 * <p>
 * 通过继承 AdaptableJobFactory 并重写 createJobInstance 方法，
 * 在 Job 实例创建后，手动将其加入 Spring IOC 容器并完成依赖注入，
 * 从而使 Job 类中的 @Autowired 注解正常工作。
 * </p>
 *
 * @author yangqiong
 */
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

	/**
	 * AutowireCapableBeanFactory 是 Spring 提供的工具，
	 * 可以将一个外部创建的对象添加到 Spring IOC 容器中，并完成该对象的依赖注入
	 */
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	/**
	 * 重写创建 Job 实例的方法
	 * <p>
	 * 先由父类创建 Job 实例对象，再通过 AutowireCapableBeanFactory
	 * 将该对象加入 Spring 容器并完成属性注入（如 @Autowired 标注的依赖）。
	 * </p>
	 *
	 * @param bundle 触发器触发时的上下文信息，包含 JobDetail 等数据
	 * @return 完成 Spring 依赖注入后的 Job 实例
	 * @throws Exception 创建或注入过程中可能出现的异常
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// 调用父类方法创建 Job 实例
		Object obj = super.createJobInstance(bundle);
		// 将 Job 实例对象添加到 Spring IOC 容器中，并完成依赖注入
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}

}
