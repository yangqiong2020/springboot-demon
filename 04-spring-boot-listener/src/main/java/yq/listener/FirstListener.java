package yq.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springboot整合 listener
 * <listener>
 *     <listener-class>yq.listener.FirstListener</listener-class>
 * </listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("firstListener ......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
