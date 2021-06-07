import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <a>Title: ApplicationContextProvider </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/3-11:38
 */
@Slf4j
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextProvider.applicationContext == null) {
            ApplicationContextProvider.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public <T> T getBean(Class<T> clazz, String name) {
        return applicationContext.getBean(name, clazz);
    }
}
