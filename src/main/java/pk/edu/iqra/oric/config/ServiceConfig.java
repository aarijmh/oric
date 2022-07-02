package pk.edu.iqra.oric.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pk.edu.iqra.oric.factory.ServiceFactory;

@Configuration
public class ServiceConfig {
    @Bean("serviceFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(ServiceFactory.class);
        return factoryBean;
    }
}
